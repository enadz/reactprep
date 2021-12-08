package deadalus.backend.config;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.okhttp.client.OkHttpRestfulClientFactory;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.api.IRestfulClientFactory;
import deadalus.backend.properties.ServiceProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ServiceProperties.class)
@AllArgsConstructor
public class HapiClientConfiguration {

  private ServiceProperties serviceProperties;

  @Bean
  public FhirContext fhirContext() {
    return new FhirContext(FhirVersionEnum.R4);
  }

  @Bean
  public IRestfulClientFactory fhirRestfulClientFactory() {
    return new OkHttpRestfulClientFactory(fhirContext());
  }

  @Bean
  public IGenericClient fhirClient(final IRestfulClientFactory clientFactory) {
    return clientFactory.newGenericClient(serviceProperties.getFhir().getUrl());
  }
}