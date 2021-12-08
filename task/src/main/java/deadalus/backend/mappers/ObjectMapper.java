package deadalus.backend.mappers;

import deadalus.backend.dtos.CodeableConceptPayload;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.instance.model.api.IIdType;

import java.util.Collection;
import java.util.List;

public interface ObjectMapper<T> {

  default String mapIdTypeToString(final IdType idType) {
    return buildResourceId(idType);
  }

  default StringType mapStringToStringType(final String string) {
    if (string == null) {
      return null;
    }
    return new StringType(string);
  }

  default String mapStringTypeToString(final StringType stringType) {
    if (stringType == null) {
      return null;
    }
    return stringType.toString();
  }

  static String buildResourceId(final IIdType idType) {
    return idType != null ? idType.getIdPart() : null;
  }
//  default TimingPayload timingToTimingPayload(Timing timing) {
//    return TimingMapper.INSTANCE.toPayload(timing.getRepeat());
//  }
//

  default Collection<CodeableConceptPayload> mapCodeableConceptList(
          final List<CodeableConcept> list) {
    return list == null ? null : CodeableConceptMapper.INSTANCE.toPayloads(list);
  }

//  default RatioPayload mapRatio(final Ratio ratio) {
//    return MappingUtil.mapRatio(ratio);
//  }


  default CodeableConceptPayload mapCodeableConcept(final CodeableConcept source) {
    if (source != null) {
      return CodeableConceptMapper.INSTANCE.toPayload(source);
    }

    return null;
  }
}
