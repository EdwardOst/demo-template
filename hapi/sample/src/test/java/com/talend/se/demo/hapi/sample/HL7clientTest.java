package com.talend.se.demo.hapi.sample;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v23.message.ADT_A01;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author EdwardOst
 */
public class HL7clientTest {

    private static final Logger log = LoggerFactory.getLogger(HL7clientTest.class);

    public HL7clientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sendADT_A01 method, of class HL7client.
     */
    @Test
    public void testSendADT_A01() throws HL7Exception, IOException {
        System.out.println("sendADT_A01");
        HL7server server = new HL7server();
        HL7client client = new HL7client(server);
        ADT_A01 adt_a01 = SampleMessages.createSample_ADT_A01();
        Message result = client.send(adt_a01);
        result.toString();
    }

}