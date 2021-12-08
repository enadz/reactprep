package deadalus.backend.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class CodeableConceptPayload implements Serializable {

    @ApiModelProperty(value = "coding", dataType = "array")
    private List<CodingPayload> coding;
    @ApiModelProperty(value = "text", dataType = "string")
    private String text;


}
