package deadalus.backend.properties;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

  private String title;
  private String description;
  private String version;
  private String license;
  private String licenseUrl;
  private Set<String> protocols;
}
