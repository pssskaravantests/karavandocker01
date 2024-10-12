import org.apache.camel.BindToRegistry;
import org.apache.camel.Configuration;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Configuration
@BindToRegistry("SetBodyForAssertion")
public class SetBodyForAssertion implements Processor {

    public void process(Exchange exchange) throws Exception {

        // Obtener el valor de la propiedades: tokenUrl y clientCredentials
        String clientCredentials = exchange.getProperty("clientCredentials").toString();
        String tokenUrl = exchange.getProperty("tokenUrl").toString();

        // asegurar el valor de la cabecera Content-Type
        exchange.setProperty("Content-Type", "application/x-www-form-urlencoded");
        exchange.getIn().setBody(clientCredentials + "&" + tokenUrl);
    }
}