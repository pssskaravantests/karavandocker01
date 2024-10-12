import org.apache.camel.BindToRegistry;
import org.apache.camel.Configuration;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.StreamCache;
import java.nio.charset.StandardCharsets;


@Configuration
@BindToRegistry("SetBodyAndHeadersForToken")
public class SetBodyAndHeadersForToken implements Processor {

    public void process(Exchange exchange) throws Exception {
        // Obtener el valor de la Propiedad 'companyCredentials'
        String companyCredentials = exchange.getProperty("companyCredentials").toString();
        
        // Establecer el fragmento de enlace
        String linkFragment = "&grant_type=urn:ietf:params:oauth:grant-type:saml2-bearer&assertion=";

        // Obtener el cuerpo del mensaje como objeto
        Object body = exchange.getIn().getBody();

        String bodyAsString = "N/A";

        // Verificar si el cuerpo es un StreamCache
        if (body instanceof StreamCache) {
            // Convertir StreamCache a String
            bodyAsString = exchange.getContext().getTypeConverter()
                           .convertTo(String.class, exchange, body);
            
            // Mostrar el contenido transformado a String
            System.out.println("El cuerpo de la respuesta recibido: " + bodyAsString);

            // Establecer el cuerpo del mensaje como String para los pasos posteriores
        } else {
            bodyAsString = body.toString();
        }

        exchange.setProperty("CamelHttpUri", "https://api12preview.sapsf.eu/oauth/token");    
        exchange.setProperty("Content-Type", "application/x-www-form-urlencoded");
        exchange.setProperty("Accept", "*/*");
        exchange.setProperty("Accept-Encoding", "deflate");

        exchange.getIn().setBody(companyCredentials + linkFragment + bodyAsString);

        System.out.println("El cuerpo de la respuesta transformado: " + bodyAsString);

    }
}