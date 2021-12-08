package deadalus.backend.mappers;

import deadalus.backend.dtos.TelecomPayload;
import org.hl7.fhir.r4.model.ContactPoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TelecomMapper extends ResourceMapper<TelecomPayload, ContactPoint> {

    TelecomMapper INSTANCE = Mappers.getMapper(TelecomMapper.class);

    @Mappings({
            @Mapping(source = "system", target = "system"),
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "use", target = "use"),
    })
    TelecomPayload toPayload(ContactPoint contactPoint);

    @Mappings({
            @Mapping(source = "system", target = "system"),
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "use", target = "use"),
    })
    ContactPoint toEntity(TelecomPayload telecomPayload);
}
