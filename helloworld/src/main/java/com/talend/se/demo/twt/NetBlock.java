package com.talend.se.demo.twt;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "NetBlock")
@XmlRootElement(name = "netblock")
public class NetBlock {
    @XmlElement(name="pingResult", required = true, nillable = true)
    public List<PingResult> pingResults = new ArrayList();
}
