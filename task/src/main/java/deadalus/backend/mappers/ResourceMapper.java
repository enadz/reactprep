package deadalus.backend.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hl7.fhir.r4.model.*;

import org.springframework.util.CollectionUtils;

public interface ResourceMapper<T1, T2> extends ObjectMapper<T1>{

  Collection<T1> toPayloads(Collection<T2> source);

  Collection<T2> toEntities(Collection<T1> source);

  T1 toPayload(T2 source);

  T2 toEntity(T1 source);

  default Collection<String> mapUriTypesToStringsCollection(final Collection<UriType> uriTypes) {
    if (CollectionUtils.isEmpty(uriTypes)) {
      return null;
    }

    final Collection<String> stringTypes = new ArrayList<>();
    uriTypes.forEach(uriType -> stringTypes.add(uriType.asStringValue()));
    return stringTypes;
  }

  default String mapCollectionStringTypesToString(final List<StringType> stringTypes) {
    if (CollectionUtils.isEmpty(stringTypes)) {
      return null;
    }
    return mapStringTypeToString(stringTypes.get(0));
  }

  default List<StringType> mapStringToCollectionStringTypes(final String string) {
    if (string == null) {
      return null;
    }
    return List.of(mapStringToStringType(string));
  }
}
