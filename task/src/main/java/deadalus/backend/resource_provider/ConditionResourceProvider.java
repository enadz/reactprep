package deadalus.backend.resource_provider;

import ca.uhn.fhir.rest.annotation.*;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;

import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.instance.model.api.IBaseResource;

import java.util.*;

public class ConditionResourceProvider  implements IResourceProvider {


    public ConditionResourceProvider() {  }

    private Map<String, Condition> conditionMap = new HashMap<String, Condition>();

    @Override
    public Class<? extends IBaseResource> getResourceType() {
        return Condition.class;
    }

    @Search
    public List<Condition> search(@RequiredParam(name = Condition.SP_ENCOUNTER) StringParam theParam) {
        List<Condition> condition = new ArrayList<Condition>();
//        condition = this.searchByPatient(theParam.getValue());
        return condition;
    }

    @Read()
    public Condition read(@IdParam IdType theId) {
        loadMockConditions();
        Condition retVal = conditionMap.get(theId.getIdPart());
        if (retVal == null) {
            throw new ResourceNotFoundException(theId);
        }
        return retVal;
    }

//    private List<Condition> searchByPatient(String patient){
//        List<Condition> retConditions;
//        loadMockConditions();
//
//        retConditions = conditionMap.values()
//                .stream()
//                .filter(next -> patient.toLowerCase().equals(next.getEncounter().toString().toLowerCase()))
//                .collect(Collectors.toList());
//        return retConditions;
//    }

    private void loadMockConditions() {

        Condition condition = new Condition();
        condition.setId("1");
        condition.addIdentifier().setSystem("http://optum.com/MRNs").setValue("001");

        this.conditionMap.put("1", condition);
        for (int i = 2; i < 5; i++) {
            condition = new Condition();
            condition.setId(Integer.toString(i));
            condition.addIdentifier().setSystem("http://optum.com/MRNs").setValue("007" + i);
            this.conditionMap.put(Integer.toString(i), condition);
        }
    }
}
