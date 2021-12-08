package deadalus.backend.dtos;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hl7.fhir.r4.model.Address;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class AddressPayload{

    @ApiModelProperty(value = "use", dataType = "enum", allowableValues = "home, wor, temp, old")
    private Address.AddressUse use;

    @ApiModelProperty(value = "type", dataType = "enum")
    private Address.AddressType type;

    @ApiModelProperty(value = "text", dataType = "string")
    private String text;

    @ApiModelProperty(value = "line", dataType = "string")
    private List<String> line;

    @ApiModelProperty(value = "city", dataType = "string")
    private String city;

    @ApiModelProperty(value = "district", dataType = "string")
    private String district;

     @ApiModelProperty(value = "state", dataType = "string")
    private String state;

    @ApiModelProperty(value = "postalCode", dataType = "string")
    private String postalCode;

    @ApiModelProperty(value = "country", dataType = "string")
    private String country;


    AddressPayload(List<String> line, String city, String state, String postalCode, String country){
        this.line=line;
        this.city=city;
        this.state=state;
        this.postalCode=postalCode;
        this.country=country;
    }
}
