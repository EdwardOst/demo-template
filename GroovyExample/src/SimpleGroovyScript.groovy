import javax.xml.xpath.*
import javax.xml.parsers.DocumentBuilderFactory

class TalendUtilities {
    
    public static parseXml (String xml, String... queries) {
        def xpath = XPathFactory.newInstance().newXPath()
        def builder     = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        def inputStream = new ByteArrayInputStream( xml.bytes )
        def records     = builder.parse(inputStream).documentElement
        
        queries.collect() {
            xpath.evaluate( it, records, XPathConstants.NODESET )?.collect(){ it.textContent }
        }
    }
}

String xmlContent = new File("C:/Users/eost/Documents/groovyExample/arinWhoIs.xml").text
String query = "/whoIs/org/name/text()"

// String xmlContent = new File(this.args[0]).text
// String query = this.args[1]

String result = TalendUtilities.parseXml( xmlContent, query )
println result