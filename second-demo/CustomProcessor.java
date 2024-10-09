import org.apache.camel.BindToRegistry;
import org.apache.camel.Configuration;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Configuration
@BindToRegistry("CustomProcessor")
public class CustomProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        com.decodedbytes.beans.SampleBean sampleBean = new com.decodedbytes.beans.SampleBean(
                "name",
                "houseNumber",
                "city",
                "province",
                "postalCode"
        );
        exchange.getIn().setBody(
            "Hello World from Custom Java Code Processor\n" +
            sampleBean.toString());
    }
}