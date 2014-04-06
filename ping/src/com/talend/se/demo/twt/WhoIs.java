package com.talend.se.demo.twt;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "WhoIs")
@XmlRootElement(name = "whoIs")
public class WhoIs {
    @XmlAttribute(required = true)
    public String ip;

    @XmlAttribute(required = true)
    public String ref;

    @XmlElement(required=true, nillable=true)
    public Network network;
    
    @XmlElement(required = true, nillable = true)
    Org org;
}
