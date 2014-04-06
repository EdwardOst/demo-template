package com.talend.se.demo.twt;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService()
public interface Arin {

    @WebMethod(operationName = "ping", action = "urn:Greet")
    @WebResult(name="whoIs")
    @RequestWrapper(className = "com.talend.se.demo.twt.Ping", localName = "ping")
    @ResponseWrapper(className = "com.talend.se.demo.twt.PingResponse", localName = "pingResponse")
    public WhoIs ping(@XmlElement(required = true) @WebParam(name = "ipAddress") String ipAddress);
}
