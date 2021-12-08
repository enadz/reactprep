package deadalus.backend.services;

import deadalus.backend.dtos.PatientPayload;
import org.hl7.fhir.r4.model.Patient;

public interface PatientServiceInterface extends BaseResourceService<Patient> {

    PatientPayload getPayload(String id);

    PatientPayload savePayload(PatientPayload payload);

    PatientPayload updatePayload(String id, PatientPayload payload);

    void deletePayload(String id);


}
