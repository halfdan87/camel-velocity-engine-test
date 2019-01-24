package testt;

import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("myVelocityEngine")
public class MyVelocityEngine extends VelocityEngine {
	
    @PostConstruct
    public void initialize(){
       log.error("It seems that I have been initialized by Spring...");
    }
	
	private static final Logger log = LoggerFactory.getLogger(MyVelocityEngine.class);

	@Override
	public Template getTemplate(String name) throws ResourceNotFoundException, ParseErrorException {
		log.error("Template requested: {}. Do I work?", name);
		return null;	
	}
	
	@Override
	public Template getTemplate(String name, String encoding) throws ResourceNotFoundException, ParseErrorException {
		log.error("Template requested: {}. Do I work?", name);
		return null;
	}
	
	@Override
	public boolean evaluate(Context context, Writer out, String logTag, String instring)
			throws ParseErrorException, MethodInvocationException, ResourceNotFoundException {
		log.error("Context: {}., string:  {}", context, instring);
		return false;
	}
	
	@Override
	public boolean evaluate(Context context, Writer writer, String logTag, Reader reader)
			throws ParseErrorException, MethodInvocationException, ResourceNotFoundException {
		log.error("Context: {}, string:  {}", context, reader);		
		return false;
	}

	@Override
	public void reset() {
		log.error("Template requested. Do I work?");
	}

	@Override
	public void init(String propsFilename) {
		log.error("Template requested: {}. Do I work?", propsFilename);
	}

	@Override
	public void init(Properties p) {
		log.error("Template requested: {}. Do I work?", p);
	}

	@Override
	public void setProperty(String key, Object value) {
		log.error("Template requested: {}. Do I work?", value);
	}

	@Override
	public void addProperty(String key, Object value) {
		log.error("Template requested: {}. Do I work?", value);
	}

	@Override
	public void clearProperty(String key) {
		log.error("Template requested: {}. Do I work?", key);
	}

	@Override
	public void setProperties(Properties configuration) {
		log.error("Template requested: {}. Do I work?", configuration);
	}

	@Override
	public Object getProperty(String key) {
		log.error("Template requested: {}. Do I work?", key);
		return null;
	}

	@Override
	public boolean invokeVelocimacro(String vmName, String logTag, String[] params, Context context, Writer writer) {
		log.error("Template requested: {}. Do I work?", vmName);
		return false;
	}

	@Override
	public boolean mergeTemplate(String templateName, String encoding, Context context, Writer writer)
			throws ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		log.error("Template requested: {}. Do I work?", templateName);
		return false;
	}

	@Override
	public boolean resourceExists(String resourceName) {
		log.error("Template requested: {}. Do I work?", resourceName);
		return false;
	}

	@Override
	public Logger getLog() {
		log.error("Template requested. Do I work?");
		return null;
	}

	@Override
	public void setApplicationAttribute(Object key, Object value) {
		log.error("Template requested: {}, {}. Do I work?", key, value);
	}

	@Override
	public Object getApplicationAttribute(Object key) {
		log.error("Template requested: {}. Do I work?", key);
		return null;
	}

	@Override
	public void removeDirective(String name) {
		log.error("Template requested: {}. Do I work?", name);
	}

	@Override
	public void loadDirective(String directiveClass) {
		log.error("Template requested: {}. Do I work?", directiveClass);
	}
	
	
}
