package com.talend.se.demo.twt;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Org")
@XmlRootElement(name = "org")
public class Org {
    @XmlAttribute(required = true)
    public String handle;

    @XmlAttribute(required = true)
    public String name;

    @XmlAttribute(required = true)
    public String ref;

    @XmlElement(required = true, nillable = true)
    Address address;
}
