package deadalus;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jpa.rp.r4.PatientResourceProvider;
import ca.uhn.fhir.rest.server.RestfulServer;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fhir/*")
public class SimpleRestfulServer extends RestfulServer {
        //Initialize
    @Override
    protected void initialize()throws ServletException{
        //create a context for the appropriate version
        setFhirContext(FhirContext.forR4());
        //Register Resource Providers
        registerProvider(new PatientResourceProvider());

    }
}