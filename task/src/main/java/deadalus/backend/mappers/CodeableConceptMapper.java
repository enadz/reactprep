package deadalus.backend.mappers;

import java.util.Collection;

import deadalus.backend.dtos.CodeableConceptPayload;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.mapstruct.factory.Mappers;

public interface CodeableConceptMapper {

  Collection<CodeableConceptPayload> toPayloads(Collection<CodeableConcept> source);

  Collection<CodeableConcept> toEntities(Collection<CodeableConceptPayload> source);

  CodeableConceptPayload toPayload(CodeableConcept source);

  CodeableConcept toEntity(CodeableConceptPayload source);

  CodeableConceptMapper INSTANCE = Mappers.getMapper(CodeableConceptMapper.class);
  
}
