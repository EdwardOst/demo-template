package com.talend.se.demo.groovy.util

import javax.xml.xpath.*
import javax.xml.parsers.DocumentBuilderFactory


class TalendBpmUtilities {

    static def parseXml(String xml, String... queries) {
	def xpath = XPathFactory.newInstance().newXPath()
	def builder     = DocumentBuilderFactory.newInstance().newDocumentBuilder()
	def inputStream = new ByteArrayInputStream( xml.bytes )
	def records     = builder.parse(inputStream).documentElement
	
	return queries.collect() {
            xpath.evaluate( it, records, XPathConstants.NODESET )?.collect(){ it.textContent }
	}
    }
    
}

