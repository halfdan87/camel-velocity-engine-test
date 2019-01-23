package testt;

import javax.annotation.PostConstruct;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("myVelocityEngine")
public class MyVelocityEngine extends VelocityEngine {
	
    @PostConstruct
    public void init(){
       log.error("It seems that I have been initialized by Spring...");
    }
	
	private static final Logger log = LoggerFactory.getLogger(MyVelocityEngine.class);

	@Override
	public Template getTemplate(String name) throws ResourceNotFoundException, ParseErrorException {
		log.error("Template requested: {}. Do I work?", name);
		return super.getTemplate("test2.vm");	
	}
	
	@Override
	public Template getTemplate(String name, String encoding) throws ResourceNotFoundException, ParseErrorException {
		log.error("Template requested: {}. Do I work?", name);
		return super.getTemplate("test2.vm", encoding);
	}
}
