package sample.cwe476;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLUtil {
	
	public static Document getDocument(String tag) throws ParserConfigurationException {
		return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}
	
	public static void setString(Document document, String node, String value) {
		Element element = document.createElement(node);
		element.setTextContent(value);
	}
	
	public static String getString(Document document, String node) {
		NodeList nodeList = document.getElementsByTagName(node);
		
		if (nodeList.getLength() > 0) {
			return nodeList.item(0).getTextContent();
		}
		return null;
	}
}