import org.apache.camel.BindToRegistry;
import org.apache.camel.Configuration;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Configuration
@BindToRegistry("MiProcesadorBean")
public class MiProcesadorBean implements Processor {

    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        exchange.getIn().setBody(body + " - Modificado por MiProcesadorBean");
        exchange.getIn().setHeader("miHeader", "nuevoValor");
    }
}