package com.talend.se.demo.helloworld;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.MockEndpoints;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@RunWith(CamelSpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:container.xml",
    "classpath:beans.xml",
    "classpath:integration.xml",
    "classpath:/com/talend/se/demo/helloworld/HelloWorldTest-context.xml"
})
@MockEndpoints
public class HelloWorldTest {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldTest.class);

    @Autowired
    private ApplicationContext springContext;
    
    @Produce(uri = "direct:invokeHelloWorld", context="helloWorldTest")
    private ProducerTemplate start;

    @EndpointInject(uri="mock:log:helloWorldRequest", context="helloWorldTest")
    private MockEndpoint requestEndpoint;

    @EndpointInject(uri="mock:result", context="helloWorldTest")
    private MockEndpoint resultEndpoint;
    
    /**
     * Test of printSystemProperties method, of class PropertyList.
     */
    @Test
    public void testLoadContainer() {
        System.out.println("testLoadContainer");
        String container = System.getProperty("container", "spring");
        
        final String expectedTestContainerProperty = "containerPropertyValue" + "." + container + ".test";
        String testContainerProperty = springContext.getBean("testContainerProperty", String.class);
        assertEquals("testContainerProperty failed: ", expectedTestContainerProperty, testContainerProperty);

        final String expectedAppPropertyValue = "appPropertyValue";
        String testAppProperty = springContext.getBean("testAppProperty", String.class);
        assertEquals("testAppProperty failed: ", expectedAppPropertyValue, testAppProperty);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            log.error("testLoadContainer InterruptedException", ex);
        }
    }


    @Test
    public void testHelloWorld_greet() throws InterruptedException {
        System.out.println("testHelloWorld_greet");
        String message = "Edward Ost";
        requestEndpoint.expectedBodiesReceived(message);
        resultEndpoint.message(0).body(String.class).startsWith("Bonjour Edward Ost time in Europe/Paris is");
        start.sendBody(message);
        requestEndpoint.assertIsSatisfied();
        resultEndpoint.assertIsSatisfied();
    }

    
}
