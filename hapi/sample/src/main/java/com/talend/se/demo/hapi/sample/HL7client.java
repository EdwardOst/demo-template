package com.talend.se.demo.hapi.sample;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v23.message.ADT_A01;
import ca.uhn.hl7v2.model.v23.segment.MSH;
import ca.uhn.hl7v2.model.v23.segment.PID;
import ca.uhn.hl7v2.parser.Parser;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author EdwardOst
 */
public class HL7client {

    private static final Logger log = LoggerFactory.getLogger(HL7client.class);
    private HapiContext hapiContext;
    private Parser parser = null;

    private HL7server hl7server;
    private final String sampleMessage = "MSH|^~\\&|ADT-HIS||HL7INSPECTOR||20060101100000||ADT^A01|1|P|2.3";

    public HL7client() {
        this(new DefaultHapiContext(), new HL7server());
    }

    public HL7client(HL7server hl7server) {
        this(new DefaultHapiContext(), hl7server);
    }

    public HL7client(HapiContext hapiContext, HL7server hl7server) {
        this.hapiContext = hapiContext;
        this.hl7server = hl7server;
    }

    public Message send(Message message) throws HL7Exception, IOException {
        log.info("send: request:\n{}", message);
        Message result = hl7server.receive(message);
        log.info("send: reply:\n{}", message);
        return result;
    }

    public String getSampleMessage() {
        return sampleMessage;
    }

    public HL7server getHl7server() {
        return hl7server;
    }

    public void setHl7server(HL7server hl7server) {
        this.hl7server = hl7server;
    }

    public void setHapiContext(HapiContext hapiContext) {
        this.hapiContext = hapiContext;
    }

    public HapiContext getHapiContext() {
        return hapiContext;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Parser getParser() {
        if (parser == null) {
            parser = hapiContext.getPipeParser();
        }
        return parser;
    }


}
