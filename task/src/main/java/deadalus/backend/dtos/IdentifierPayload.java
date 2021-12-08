package deadalus.backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.r4.model.Identifier;

@Getter
@Setter
public class IdentifierPayload {

    private Identifier.IdentifierUse use;
    private String value;
}
