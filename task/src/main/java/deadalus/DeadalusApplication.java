package deadalus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class DeadalusApplication {


    public static void main(String[] args) {
        SpringApplication.run(DeadalusApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean ServletRegistrationBean(){
        ServletRegistrationBean registration=new ServletRegistrationBean(new SimpleRestfulServer(),"/fhir/*");
        registration.setName("FhirServlet");
        return registration;
    }
}
