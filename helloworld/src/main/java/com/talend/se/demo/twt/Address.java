package com.talend.se.demo.twt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Address")
@XmlRootElement(name = "address")
public class Address {
    
    public Address() {}
    
    public Address(String city, String state, String zip) {
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    @XmlElement(required = true, nillable = true)
    public String city;

    @XmlElement(required = true, nillable = true)
    public String state;

    @XmlElement(required = true, nillable = true)
    public String zip;
}
