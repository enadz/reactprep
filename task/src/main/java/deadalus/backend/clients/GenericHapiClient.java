package deadalus.backend.clients;

import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.Bundle.BundleLinkComponent;
import org.hl7.fhir.r4.model.Resource;

@AllArgsConstructor
public abstract class GenericHapiClient<T extends Resource> {

    private IGenericClient client;

    //Save FHIR object
    public T save(T resource) {
        MethodOutcome outcome = client.create()
                .resource(resource)
                .prettyPrint()
                .encodedJson()
                .execute();
        return (T) outcome.getResource();
    }

    //Update FHIR object
    public void update(T resource) {
        client.update()
                .resource(resource)
                .prettyPrint()
                .encodedJson()
                .execute();
    }

    //Update FHIR object by id
    public void update(T resource, String resourceId) {
        client.update()
                .resource(resource)
                .withId(resourceId)
                .prettyPrint()
                .encodedJson()
                .execute();
    }


    //Update and retrieve FHIR object.
    public T updateAndGet(T resource) {
        final String resourceId =  resource.getIdElement().getIdPart();
        update(resource, resourceId);
        return getById(resourceId);
    }

    //Update and retrieve FHIR object by id.
    public T updateAndGet(T resource, String resourceId) {
        update(resource, resourceId);
        return getById(resourceId);
    }


    //Read FHIR resource by ID
    public T getById(String id) throws ResourceNotFoundException {
        return getClient().read().resource(getResourceClass()).withId(id).execute();
    }


    //Delete resource in HAPI storage
    public void delete(T resource) {
        resource.setMeta(null);

        getClient()
                .delete()
                .resource(resource)
                .execute();
    }

    //Delete resource in FHIR storage by id.
    public void deleteById(String id) {
        getClient().delete().resourceById(getResourceClass().getSimpleName(), id).execute();
    }

    public IGenericClient getClient() {
        return client;
    }

    protected Collection<T> getAllResources(final Bundle bundle) {
        final Collection<T> resources = new ArrayList<>();

        addResources(resources, bundle);
        String nextUrl;

        final BundleLinkComponent linkComponent = bundle.getLink("next");

        if (linkComponent != null) {
            nextUrl = linkComponent.getUrl();

            while (StringUtils.isNotBlank(nextUrl)) {
                final Bundle nextBundle = getClient()
                        .search()
                        .byUrl(nextUrl)
                        .returnBundle(Bundle.class)
                        .execute();

                addResources(resources, nextBundle);

                final BundleLinkComponent nextLinkComponent = nextBundle.getLink("next");

                nextUrl = nextLinkComponent != null ? nextLinkComponent.getUrl() : null;
            }
        }
        return resources;
    }

    private void addResources(final Collection<T> resources, final Bundle bundle) {
        bundle.getEntry().stream()
                .map(BundleEntryComponent::getResource)
                .forEach(resource -> resources.add((T) resource));
    }

    protected Collection<T> getResources(final Bundle bundle) {
        return bundle.getEntry().stream()
                .map(BundleEntryComponent::getResource)
                .map(resource -> (T) resource)
                .collect(Collectors.toList());
    }

    public abstract Class<T> getResourceClass();
}
