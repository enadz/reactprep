package deadalus.backend.mappers;

import deadalus.backend.dtos.PatientPayload;
import org.hl7.fhir.r4.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper extends ResourceMapper<PatientPayload,Patient>{

    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    @Mappings({
//            @Mapping(source = "resourceId", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "active", target = "active")
    })
    PatientPayload toPayload(Patient patient);

    @Mappings({
//            @Mapping(source = "id", target = "resourceId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "gender", target = "gender"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "active", target = "active")
    })
    Patient toEntity(PatientPayload patientPayload);
}
