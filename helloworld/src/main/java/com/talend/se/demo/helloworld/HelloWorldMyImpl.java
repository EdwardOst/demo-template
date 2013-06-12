package com.talend.se.demo.helloworld;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldMyImpl implements HelloWorld{

	private static final Logger log = LoggerFactory.getLogger(HelloWorldMyImpl.class);	
	
	private String timeZone = "America/New_York";
	private String postMessage = "Good day.";

	public HelloWorldMyImpl() {
	}
	
	public String greet(String name) {
		Date today = new Date();
		DateFormat df = DateFormat.getDateTimeInstance();
		df.setTimeZone(TimeZone.getTimeZone(timeZone));
		String result = "Hello " + name + " time in " + timeZone + " is " + df.format(today) + ".  " + postMessage;
		log.info(this.getClass().getName() + ".greet: " + result);
		return result;
	}

	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

}
