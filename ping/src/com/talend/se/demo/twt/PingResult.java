package com.talend.se.demo.twt;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType(name = "PingResult")
@XmlRootElement(name = "pingResult")
public class PingResult {
    @XmlAttribute
    public String host;
    
    @XmlAttribute
    public String returnValue;
    
    @XmlValue
    public String pingResult;
}
