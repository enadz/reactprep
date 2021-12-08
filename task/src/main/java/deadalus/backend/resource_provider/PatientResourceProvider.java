package deadalus.backend.resource_provider;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.annotation.*;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.instance.model.api.IBaseResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class PatientResourceProvider implements IResourceProvider {

    public PatientResourceProvider() {  }

    private Map<String, Patient> patientMap = new HashMap<String, Patient>();

    @Override
    public Class<? extends IBaseResource> getResourceType() {
        return Patient.class;
    }

    @Create
    public MethodOutcome create(@ResourceParam Patient patient){

        FhirContext fhirContext = FhirContext.forDstu3();
//        String serverBaseUrl = "http://hl7.org/fhir";
        String serverBaseUrl = "http://hapi.fhir.org/baseR4";

        IGenericClient client = fhirContext.newRestfulGenericClient(serverBaseUrl);

        MethodOutcome outcome = client
                .create()
                .resource(patient)
                .execute();

        return outcome;
    }

//    @Search
//    public List<Patient> searchByLastName(@RequiredParam(name = Patient.SP_FAMILY) StringParam theParam) {
//        List<Patient> patients = new ArrayList<Patient>();
//        patients = this.searchByFamilyName(theParam.getValue());
//        return patients;
//    }

    @Search
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<Patient>();
        patients = this.searchAllPatients();
        return patients;
    }

    @Read()
    public Patient read(@IdParam IdType theId) {
        loadMockPatients();
        Patient retVal = patientMap.get(theId.getIdPart());
        if (retVal == null) {
            throw new ResourceNotFoundException(theId);
        }
        return retVal;
    }

    private List<Patient> searchByFamilyName(String familyName){
        List<Patient> retPatients;
        loadMockPatients();

        retPatients = patientMap.values()
                .stream()
                .filter(next -> familyName.toLowerCase().equals(next.getNameFirstRep().getFamily().toLowerCase()))
                .collect(Collectors.toList());
        return retPatients;
    }

//    private List<Patient> searchByPractitionerName(Practitioner generalPractitioner){
//        List<Patient> retPatients;
//        loadMockPatients();
//
//        retPatients = patientMap.values()
//                .stream()
//                .filter(next -> generalPractitioner.equals(next.getGeneralPractitioner()))
//                .collect(Collectors.toList());
//        return retPatients;
//    }

    private List<Patient> searchAllPatients(){
        List<Patient> retPatients;
        loadMockPatients();

        retPatients = patientMap.values()
                .stream()
                .collect(Collectors.toList());
        return retPatients;
    }


    private void loadMockPatients() {

        Patient patient = new Patient();
        patient.setId("1");
        patient.addIdentifier().setSystem("http://optum.com/MRNs").setValue("007");
        patient.addName().setFamily("Doe").addGiven("Jane").addGiven(" ");
        patient.setGender(Enumerations.AdministrativeGender.FEMALE);
        patient.addAddress().addLine("Address Line 1");
        patient.addAddress().setCity("St. Petersburg");
        patient.addAddress().setCountry("Russia");
        patient.addTelecom().setValue("111-111-1111");
//        patient.addGeneralPractitioner().
        this.patientMap.put("1", patient);
        for (int i = 2; i < 6; i++) {
            patient = new Patient();
            patient.setId(Integer.toString(i));
            patient.addIdentifier().setSystem("http://optum.com/MRNs").setValue("007" + i);
            patient.addName().setFamily("Bond" + i).addGiven("J").addGiven("");
            if (i%2==0) patient.setGender(Enumerations.AdministrativeGender.FEMALE);
            else patient.setGender(Enumerations.AdministrativeGender.MALE);
            patient.addAddress().addLine("House Line " + i);
            patient.addAddress().setCity("Your City");
            patient.addAddress().setCountry("USA");
            this.patientMap.put(Integer.toString(i), patient);
        }
    }
}

