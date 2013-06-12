package com.talend.se.demo.hapi.sample;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v23.message.ADT_A01;
import ca.uhn.hl7v2.model.v23.segment.MSH;
import ca.uhn.hl7v2.model.v23.segment.PID;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author EdwardOst
 */
public class SampleMessages {

    private static final Logger log = LoggerFactory.getLogger(SampleMessages.class);


    public static ADT_A01 createSample_ADT_A01() throws HL7Exception, IOException {
        ADT_A01 adt = new ADT_A01();
        adt.initQuickstart("ADT", "A01", "T");

        // populate MSH
        MSH mshSegment = adt.getMSH();
        mshSegment.getSendingApplication().getNamespaceID().setValue("HL7client");
        mshSegment.getSequenceNumber().setValue("100");

        PID pid = adt.getPID();
        pid.getPatientName(0).getFamilyName().setValue("Ed");
        pid.getPatientName(0).getGivenName().setValue("Ost");

        return adt;
    }


}
