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

        //String newBodyContent = clientCredentials + "&" + tokenUrl;
        String newBodyContent = "client_id=YWQzYTRmNzYzZGEyOGJjNTRhNWU5YmU0NDY4NQ&user_id=adminnttemeal&token_url=https://api12preview.sapsf.eu/oauth/token&private_key=TUlJRXZnSUJBREFOQmdrcWhraUc5dzBCQVFFRkFBU0NCS2d3Z2dTa0FnRUFBb0lCQVFEaU1MVVF0Rnp4bXduQ2VHWFFKNUVDS1VKNG91T0FjTnVlNm52TExUSlBRWGZzUTJ6TUhHU0xudy8vYy9ldERVMVI5bTNXTmd3cXRvY0Q5Sjg5R01nSU8wZEVHQWwvV25TSlp1YzZicGVVcThtR2tyTE5pUXA4TzAxMUsrU01qVVJyV1RTM2tPUUhRdzZHTmFsRVFwc0xLaGJBNDBNRUtDUEY3Y1VCcFBHTlRSNWNvWEVUb21xN1czeVdmQjc2VXQyTVk3U3NZUjNheXQrZlBwazFXc1F5dzZNalovM1V0UTN1ekZwMHIvT3BldnJtZndoREowclB2N3ByVWErZ3J2cGNuMnRNb2Z6K3NXUWU5WWErLzFKVFJRSVZmYlZDbGhWNTRNTW9CcWprNUMyUXBicFhGRmlLRXNTeGx6OFlBZ1FlNjVHOWlLNXJDUmc3OS84ZllqeTNBZ01CQUFFQ2dnRUFIQ3cxUHBXUWZBd0pBbFFOQTdPM1A5M1VFeTJLczVmd1ZaSUpoWmJRRE56RkswUXNwc2I1NDdBV0Jkc3p1V0M0OERheG16dytkZ3JTWDBwQlBwSzV4aTRIK1ljYTY3dGdYTnJZZmNmWGtTTjMwRG9HYVBaTmtZZ0dENkdUYjhtS3E1VHFyWVhhVG1pVTd3b21WcGtMTWEvMk1lUG5RdEJ6Rll5V0oxY2NPbDArMTlmYXZNcHpyUnc0dkRseEhkRWhzdUhHcHJwcTdHN2xBSHI1azYvNHVIMFRxSDhwU3g3SldlZzNJZkQvOEJEYk5lVThyQkF3K2xscjkyVE5ieDBlMC9RblZ5M0UzanE1WElsSE8wL3FySzZRaDhwOVdzREQwUFdaNjh1T1ZRbHVNcGRhRFNtRDVsS1BsMFN0ekZ4VjZVbXorVnlSL3dLUFVQdFREUTJYMVFLQmdRRHA3cHRUNjRVZzd0UHl4NW9lbmc4bUVkZDJ4aTRnVVZLclFMTmVUY3VaV2h0b05NOXZ5WG9GR0tMZlo0T1pBVy9qaE1TOEVQWFlNVWIvS3I5aVpvNWJpVW94Nk0vSWVkVjRFUmdMRHA5WG5xSmM4bTdHVm01a0QwY1JLYTNsWEhaMVBVNmFGc2NPS01vRkkzTWJOTFViOHRLVlFHUllvdWw5dDJKWFRuc3Z2UUtCZ1FEM2h5TnNqMU10MlRsQ1hOeW93Ni8vWVU3Rm16Qzg3OGcvTFdWSk1mUHJhZE4vM05YUGpnV2JDSWd4RHlVWHE4d3BKVHpxdFpwUWliLzdBQ2JFbDVnS3puNUxJcXRIVks5R29sZXlSV2FmaUw5bHBRS05JOEZxVHFqamR1N2JVVjF1UlFCVC8xcms4M2VpL0NJOFNUaTdtOU05ZlRRSk93cVF1MVVZdGgxN2d3S0JnRzZYdmxrclJESHdsc1QxTmxoNU13STFkeDZRektlOHFvK0p0QUxHVnBXMk1yVE9HcTlubWNjbEFZTUtoZjFrMzRlNWNlVFRROWFrWFVNdTYzSFN1RVJ3SUdKK0JSVnErOCthalRwVS9HSEkva3RnMVp2d3FwbWxXMXl5enFKYlZ5bFFCWVAxZHIrcjZ1NEk5MWNLVVFEWWlGUEZNR3R6QVYzTXY3STB5U29sQW9HQkFOUTllYkJpREk1cGplRkxRcUVxZWNSZUtXN2lySjIwZEYxSGpXdC9lNGpGaXVZOThzOHZGYnRqUzNQVmFwYXJaamw1aG93eC93bERzK3VDcTdzeHlOcXJTRHNnbFFCcXFvZkVON0hTTkRaaXlNcGMvSjBNcFpHRHRPaWxXQldSNUt6aVdXK3Nxc0ZaeWFGazArNGhVcFg2L052aWVUWFkvQ3d4bEx2Rm0rNEZBb0dCQUl4VC9hSWtGc1d0b2ZhN2JxRlJ4QzlvNFl3OG00RFpLTGhKeU9mNlpyWHlSVkgxellBM294R2xWZlVVRUtaSk4wWHRpaUJXd0VMZk5MTVZCbFE2VTRFZy81ektTNDUvWGxOMFJyS3BSUjNld2NTRVgwaitzTDJjeHkrb3Fsd0tJYzlhZWY4VWdCK3hmZGdMdGxQeTBmZUlERER3MGZCSXVuUkJaWGU3MGh0YyMjI0MwMDA5NDE3NDkxVDE=";
        exchange.getIn().setBody(newBodyContent);
        // asegurar valores adecuados para las cabeceras del HTTPs Request
        exchange.setProperty("Content-Type", "application/x-www-form-urlencoded");
        exchange.setProperty("CamelHttpUri", "https://api12preview.sapsf.eu/oauth/idp");
        exchange.setProperty("Accept", "*/*");
        exchange.setProperty("Cache-Control", "no-cache");
        exchange.setProperty("Accept-Encoding", "deflate");

    }
}