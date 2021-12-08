package deadalus.backend.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "service")
public class ServiceProperties {

    private Fhir fhir = new Fhir();


    @Getter
    @Setter
    public static class Fhir {

        private String url = "";
    }

}
