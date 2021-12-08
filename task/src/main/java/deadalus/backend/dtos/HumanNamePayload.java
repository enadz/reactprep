package deadalus.backend.dtos;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.hl7.fhir.r4.model.HumanName;
import java.util.List;

@Getter
@Setter
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class HumanNamePayload {

    private String family;
    private List<String> given;
    private List<String> prefix;
    private List<String> suffix;
//    private HumanName.NameUse use;

}
