package deadalus.backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.Period;


@Getter
@Setter
public class TelecomPayload {

    private ContactPoint.ContactPointSystem system;
    private String value;
    private ContactPoint.ContactPointUse use;
    private int rank;
    private Period period;


    public TelecomPayload(ContactPoint.ContactPointSystem system, String value, ContactPoint.ContactPointUse use) {
        this.system = system;
        this.value = value;
        this.use = use;
    }
}

