package com.talend.se.demo.xmljson;

import java.util.HashMap;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        // here is a sample which processes the input files
        // (leaving them in place - see the 'noop' flag)
        // then performs content based routing on the message using XPath
        
        XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
        xmlJsonFormat.setRootName("root");
        
//        from("timer:myTimer?repeatCount=1")
//            .setBody().constant("{ \"someField\": \"avalue\", \"anotherField\" : { \"childField\" : \"anotherValue\", \"childField2\" : \"anotherValue2\" } }")
        from("file:C:/Users/eost/Documents/netbeans/se/demo/xmljson/data?fileName=whois.json&noop=true")
            .unmarshal().xmljson(new HashMap<String,String>() { { put( "rootName", "pingResponse"); } })
            .to("log:result");
    }

}
