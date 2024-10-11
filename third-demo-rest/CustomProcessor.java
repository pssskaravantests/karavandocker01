import org.apache.camel.BindToRegistry;
import org.apache.camel.Configuration;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Configuration
@BindToRegistry("CustomProcessor")
public class CustomProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {

        // Obtener el cuerpo directamente como HashMap
        HashMap<String, String> body = exchange.getIn().getBody(HashMap.class);
        
        if (body != null) {
            
            // Acceder a valores específicos
            String selectedSSFIdentificator = body.get("selectedSSFIdentificator");

            // Mostrar valores
            System.out.println("selectedSSFIdentificator[" + selectedSSFIdentificator + "]");
            exchange.getIn().setProperty("selectedSSFIdentificator", selectedSSFIdentificator);
        } else {
            System.out.println("El cuerpo está vacío (null).");
        }
    }
}