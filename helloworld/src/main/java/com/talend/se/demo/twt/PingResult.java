package com.talend.se.demo.twt;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType(name = "PingResult")
@XmlRootElement(name = "pingResult")
public class PingResult {
    public PingResult() {}
    public PingResult(String host, String returnValue, String pingResult) {
        this.host = host;
        this.returnValue = returnValue;
        this.pingResult = pingResult;
    }
    
    @XmlAttribute
    public String host;
    
    @XmlAttribute
    public String returnValue;
    
    @XmlValue
    public String pingResult;
}
