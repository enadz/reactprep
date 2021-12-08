package deadalus.backend.clients;

import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientHapiClient extends GenericHapiClient<Patient> {

    public PatientHapiClient(IGenericClient client) {
        super(client);
    }

    @Override
    public Class<Patient> getResourceClass() {
        return Patient.class;
    }
}
