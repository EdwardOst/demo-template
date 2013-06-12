package com.talend.se.demo.util.camel;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author EdwardOst
 */
public class MepHelper {

    private static final Logger log = LoggerFactory.getLogger(MepHelper.class);
    private final String mepPropertyName;

    public MepHelper() {
        this.mepPropertyName = "oldMep";
    }

    public MepHelper(String mepPropertyName) {
        this.mepPropertyName = mepPropertyName;
    }

    public void pushMep(Exchange exchange) {
        pushMep(exchange, this.mepPropertyName);
    }
    
    public void pushMep(Exchange exchange, String mepPropertyName) {
        ExchangePattern mep = exchange.getPattern();
        exchange.setProperty(mepPropertyName, exchange.getPattern());
        log.info("pushMep: property.{}={}", mepPropertyName, mep.toString());
    }
    
    public void popMep(Exchange exchange) {
        popMep(exchange, this.mepPropertyName);
    }

    public void popMep(Exchange exchange, String mepPropertyName) {
        ExchangePattern mep = exchange.getProperty(mepPropertyName, ExchangePattern.class);
        exchange.setPattern(mep);
        log.info("popMep: property.{}={}", mepPropertyName, mep.toString());
    }

}
