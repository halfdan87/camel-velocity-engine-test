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
	
	@Override
	public boolean evaluate(Context context, Writer out, String logTag, String instring)
			throws ParseErrorException, MethodInvocationException, ResourceNotFoundException {
		log.error("Context: {}., string:  {}", context, instring);
		return super.evaluate(context, out, logTag, instring);
	}
	
	@Override
	public boolean evaluate(Context context, Writer writer, String logTag, Reader reader)
			throws ParseErrorException, MethodInvocationException, ResourceNotFoundException {
		log.error("Context: {}, string:  {}", context, reader);		
		return super.evaluate(context, writer, logTag, reader);
	}

	@Override
	public void reset() {
		log.error("Template requested. Do I work?");
		super.reset();
	}

	@Override
	public void init(String propsFilename) {
		log.error("Template requested: {}. Do I work?", propsFilename);
		super.init(propsFilename);
	}

	@Override
	public void init(Properties p) {
		log.error("Template requested: {}. Do I work?", p);
		super.init(p);
	}

	@Override
	public void setProperty(String key, Object value) {
		log.error("Template requested: {}. Do I work?", value);
		super.setProperty(key, value);
	}

	@Override
	public void addProperty(String key, Object value) {
		log.error("Template requested: {}. Do I work?", value);
		super.addProperty(key, value);
	}

	@Override
	public void clearProperty(String key) {
		log.error("Template requested: {}. Do I work?", key);
		super.clearProperty(key);
	}

	@Override
	public void setProperties(Properties configuration) {
		log.error("Template requested: {}. Do I work?", configuration);
		super.setProperties(configuration);
	}

	@Override
	public Object getProperty(String key) {
		log.error("Template requested: {}. Do I work?", key);
		return super.getProperty(key);
	}

	@Override
	public boolean invokeVelocimacro(String vmName, String logTag, String[] params, Context context, Writer writer) {
		log.error("Template requested: {}. Do I work?", vmName);
		return super.invokeVelocimacro(vmName, logTag, params, context, writer);
	}

	@Override
	public boolean mergeTemplate(String templateName, String encoding, Context context, Writer writer)
			throws ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		log.error("Template requested: {}. Do I work?", templateName);
		return super.mergeTemplate(templateName, encoding, context, writer);
	}

	@Override
	public boolean resourceExists(String resourceName) {
		log.error("Template requested: {}. Do I work?", resourceName);
		return super.resourceExists(resourceName);
	}

	@Override
	public Logger getLog() {
		log.error("Template requested. Do I work?");
		return super.getLog();
	}

	@Override
	public void setApplicationAttribute(Object key, Object value) {
		log.error("Template requested: {}, {}. Do I work?", key, value);
		super.setApplicationAttribute(key, value);
	}

	@Override
	public Object getApplicationAttribute(Object key) {
		log.error("Template requested: {}. Do I work?", key);
		return super.getApplicationAttribute(key);
	}

	@Override
	public void removeDirective(String name) {
		log.error("Template requested: {}. Do I work?", name);
		super.removeDirective(name);
	}

	@Override
	public void loadDirective(String directiveClass) {
		log.error("Template requested: {}. Do I work?", directiveClass);
		super.loadDirective(directiveClass);
	}
	
	
}
