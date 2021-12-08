package deadalus.backend.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class CodingPayload implements Serializable {


    @ApiModelProperty(value = "system", dataType = "string")
    private String system;

    @ApiModelProperty(value = "code", dataType = "string")
    private String code;

    @ApiModelProperty(value = "display", dataType = "string")
    private String display;

    @ApiModelProperty(value = "version", dataType = "string")
    private String version;

    @ApiModelProperty(value = "userSelected", dataType = "boolean")
    private boolean userSelected;

}
