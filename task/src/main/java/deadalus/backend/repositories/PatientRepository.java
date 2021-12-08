package deadalus.backend.repositories;
import deadalus.backend.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, String> {

}
