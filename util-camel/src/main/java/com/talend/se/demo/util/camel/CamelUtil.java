package com.talend.se.demo.util.camel;

import java.util.Map;
import org.apache.camel.CamelContext;
import org.apache.camel.spi.Registry;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.impl.PropertyPlaceholderDelegateRegistry;
import org.apache.camel.Component;
import org.apache.camel.Endpoint;
import org.apache.camel.Route;
import org.apache.camel.Service;
import org.apache.camel.spring.SpringCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelUtil {

    private static final Logger log = LoggerFactory.getLogger(CamelUtil.class);
    
    public static String printEndpoints(org.apache.camel.CamelContext context) {
    	StringBuilder sb = new StringBuilder();
    	for (Map.Entry<String, Endpoint> entry : context.getEndpointMap().entrySet()) {
    		Endpoint e = entry.getValue();
    		    sb.append(entry.getKey()).append(", ").append(e.getEndpointUri()).append(", ").append(e.getClass().getName()).append("\n");
    	}
    	return sb.toString();
    }

    public static String printComponents(CamelContext context) {
    	StringBuilder sb = new StringBuilder();
    	for (String componentName : context.getComponentNames()) {
    		Component component = context.getComponent(componentName);
    		    sb.append(componentName).append(": ").append(component.getClass().getName()).append("\n");
    	}
    	return sb.toString();
    }

    public static String printRoutes(CamelContext context) {
    	StringBuilder sb = new StringBuilder();
    	for (Route route : context.getRoutes()) {
    		    sb.append(printRoute(route)).append("\n");
    	}
    	return sb.toString();
    }
    
    public static String printRoute(Route route) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(route.getId());
    	for (Service service : route.getServices()) {
    		    sb.append(" : ").append( service.getClass().getName());
    	}
    	return sb.toString();
    }

    public static String printRegistry(CamelContext context) {
    	return printRegistry(context.getRegistry());
    }
    
    public static String printRegistry(Registry registry) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(registry.getClass().getName());
    	if (registry instanceof PropertyPlaceholderDelegateRegistry) {
    		PropertyPlaceholderDelegateRegistry pphdRegistry = (PropertyPlaceholderDelegateRegistry) registry;
        	    sb.append("(").append(printRegistry(pphdRegistry.getRegistry())).append(")");
    	}
    	return sb.toString();
    }

    // this method does not work
    public static String printRegistryContents(Registry registry) {
    	StringBuilder sb = new StringBuilder();
    	Map<String, Object> entries = registry.lookupByType(Object.class);
    	    sb.append("registry size =").append(entries.size());
    	for (String key : entries.keySet()) {
    		    sb.append(key).append(": ").append(entries.get(key).getClass().getCanonicalName()).append("\n");
    	}
    	return sb.toString();
    }
    
    public static JndiRegistry getJndiRegistry(Registry registry) {
    	while (registry instanceof PropertyPlaceholderDelegateRegistry) {
    		PropertyPlaceholderDelegateRegistry pphdRegistry = (PropertyPlaceholderDelegateRegistry) registry;
        	registry = pphdRegistry.getRegistry();
    	}
    	if (registry instanceof JndiRegistry) {
    		return (JndiRegistry) registry;
    	}
    	
    	return null;
    }
    
    public static javax.naming.Context getJndiContext(CamelContext context) {
    	JndiRegistry jndiRegistry = getJndiRegistry(context.getRegistry());
    	javax.naming.Context jndiContext;
    	if (jndiRegistry == null) 
    		return null;
    	try {
    		jndiContext = jndiRegistry.getContext();
    	} catch (Exception e) {
                log.error("Error getting ndi context", e.toString());
    		return null;
    	}
    	return jndiContext;
    }
    
    public static SpringCamelContext loadSpring(CamelContext camelContext, String[] springContextFiles, String springCamelContextId) {
    	SpringCamelContext springCamelContext;

    	System.out.println("Creating spring context");
    	ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext(springContextFiles);
    	System.out.println("spring context created");

   		System.out.println("merging with camel context from spring xml file");
   		springCamelContext = springContext.getBean(springCamelContextId, SpringCamelContext.class);

    	for(String name : camelContext.getComponentNames()){
    		Component component = camelContext.getComponent(name);
    		// spring file takes precedence
    		if (springCamelContext.getComponent(name) == null)
    			springCamelContext.addComponent(name, component);
    	}
    	return springCamelContext;
    }
}
