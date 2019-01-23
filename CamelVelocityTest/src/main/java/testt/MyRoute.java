package testt;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	    from("timer:test?period={{period}}")
	      .to("velocity:test.vm").log(LoggingLevel.INFO, "${body}");

	}
}