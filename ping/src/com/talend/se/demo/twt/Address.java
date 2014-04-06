package com.talend.se.demo.twt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Address")
@XmlRootElement(name = "address")
public class Address {
    @XmlElement(required = true, nillable = true)
    public String city;

    @XmlElement(required = true, nillable = true)
    public String state;

    @XmlElement(required = true, nillable = true)
    public String zip;
}
