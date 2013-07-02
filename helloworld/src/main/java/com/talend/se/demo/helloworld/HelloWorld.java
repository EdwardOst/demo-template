package com.talend.se.demo.helloworld;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService()
public interface HelloWorld {

	@WebMethod(operationName = "greet", action = "urn:Greet")
	@WebResult(targetNamespace="http://helloworld.service.demo.se.talend.com/")
	@RequestWrapper(className = "com.talend.se.demo.service.helloworld.Greet", localName = "greet", targetNamespace = "http://helloworld.service.demo.se.talend.com/")
	@ResponseWrapper(className = "com.talend.se.demo.service.helloworld.GreetResponse", localName = "greetResponse", targetNamespace = "http://helloworld.service.demo.se.talend.com/")
	public String greet(@WebParam(name = "name") String name);

}