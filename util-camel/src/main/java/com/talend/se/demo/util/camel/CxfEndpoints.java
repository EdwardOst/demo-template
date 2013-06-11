package com.talend.se.demo.util.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.component.cxf.CxfSpringEndpoint;
import org.apache.camel.spi.Registry;
import org.apache.cxf.jaxws.EndpointImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CxfEndpoints {

    private static final Logger log = LoggerFactory.getLogger(CxfEndpoints.class);
    private String[] beanList;
    private Registry registry;

    public CxfEndpoints(Registry registry, String[] beanList) {
        this.registry = registry;
        this.beanList = beanList.clone();
    }

    public CxfEndpoints(CamelContext context, String[] beanList) {
        this(context.getRegistry(), beanList);
    }

    public void printCxfEndpointAddresses() {
        log.info("CXF Endpoint Addresses");
        for (String beanId : beanList) {
            Object bean = registry.lookup(beanId);
            if (bean instanceof org.apache.cxf.jaxws.EndpointImpl) {
                EndpointImpl endpointImpl = registry.lookup(beanId, EndpointImpl.class);
                String address = endpointImpl.getAddress();
                log.info(beanId + " at " + address);
            } else if (bean instanceof org.apache.camel.component.cxf.CxfSpringEndpoint) {
                CxfSpringEndpoint endpointImpl = (org.apache.camel.component.cxf.CxfSpringEndpoint) bean;
                String address = endpointImpl.getAddress();
                log.info(beanId + " at " + address);
            }

        }
    }
}
