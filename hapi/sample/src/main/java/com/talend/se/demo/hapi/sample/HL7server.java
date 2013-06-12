package com.talend.se.demo.hapi.sample;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author EdwardOst
 */
public class HL7server {

    private HapiContext hapiContext;
    private Parser parser;

    public HL7server() {
        this(new DefaultHapiContext());
    }
    
    public HL7server(HapiContext hapiContext) {
        this.hapiContext = hapiContext;
    }
    
    private static final Logger log = LoggerFactory.getLogger(HL7server.class);

    public Message receive(Message message) throws HL7Exception, IOException {
        log.info("receive: request:\n{}", message);

        String serverEncodedMessage = hapiContext.getXMLParser().encode(message);
        log.info("receive reply:\n{}", serverEncodedMessage);

        Message ack = message.generateACK();
        return ack;
    }
    
    public HapiContext getHapiContext() {
        return hapiContext;
    }

    public void setHapiContext(HapiContext hapiContext) {
        this.hapiContext = hapiContext;
    }

    public Parser getParser() {
        if (parser == null) {
            parser = hapiContext.getXMLParser();
        }
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }
    
}
