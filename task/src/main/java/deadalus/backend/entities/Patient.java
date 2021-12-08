package deadalus.backend.entities;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "patient")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @Column(name = "patient_id")
    private String patientId;

    //public GFitPatient(int patientId) {this.patientId = patientId;}

}
