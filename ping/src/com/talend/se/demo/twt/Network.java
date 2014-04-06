package com.talend.se.demo.twt;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Network")
@XmlRootElement(name = "network")
public class Network {

    @XmlAttribute(required = true)
    public String ref;

    @XmlElement(name="netblock", required = true, nillable = true)
    @XmlElementWrapper(required = true, nillable = true, name = "netblocks")
    public List<NetBlock> netblocks;
    
}
