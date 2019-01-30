package testt;

import java.util.Collections;
import java.util.Set;

import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {
	
    @Autowired
    private CamelContext camelContext;

	@Override
	public void configure() throws Exception {
	    from("timer:test?period={{period}}")
	    .process(exchange -> {
	    	exchange.getIn().setBody(Collections.singletonMap("template", "template.vm"));
	    })
	    .to("velocity:bean:myRoute.testMethod(${body['template']})")
	    .log(LoggingLevel.INFO, "Body: ${body}")
	    
	    .process(exchange -> {
	    	exchange.getIn().setBody(Collections.singletonMap("template", "template.vm"));
	    })
	    
	    .recipientList().simple("velocity:bean:myRoute.testMethod(${body['template']})")
	    .log(LoggingLevel.INFO, "Body: ${body}")
	    
	    .process(exchange -> {
            MBeanServer mbeanServer = camelContext.getManagementStrategy().getManagementAgent().getMBeanServer();
            Set<ObjectName> objNameSet = mbeanServer.queryNames(new ObjectName("org.apache.camel:type=endpoints,name=\"velocity*\",*"), null);

            log.error("Mbeans found: {}", objNameSet.size());
            objNameSet.forEach(objectName -> {
            	try {
					MBeanInfo mBeanInfo = mbeanServer.getMBeanInfo(objectName);
					
					log.error("MBean: {}", mBeanInfo);
				} catch (IntrospectionException | InstanceNotFoundException | ReflectionException e) {
					e.printStackTrace();
				}

            });
	    })
	    
	    ;	    
	}
	
	
	public String testMethod(String template) {
		log.debug("Body in test method: {}", template);
		return "test template: " + template;
	}
}