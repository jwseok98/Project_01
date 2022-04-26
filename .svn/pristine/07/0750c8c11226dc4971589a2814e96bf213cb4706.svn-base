/*
 * 참조: 없음. 스프링 MVC 기반 샘플 - XPath 삽입
 */
package sample.cwe643.spring;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Controller
public class CWE643_xpi_spring_basic_bad01 {
	
	@ResponseBody
	@RequestMapping(value="/viewAuthInfo")
	public String viewAuthInfo(String userName) throws Exception {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		InputSource source = new InputSource("systemId");
		Document doc = documentBuilder.parse(source);
		
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		
		// POTENTIAL FLAW
		XPathExpression expr = xpath.compile("//users/user[login/text()='" + userName + "']/home_dir/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		
		for (int i=0; i<nodes.getLength(); i++) {
			String value = nodes.item(i).getNodeValue();
			if (value.indexOf(">") < 0) {
				return value;
			}
		}
		
		return "no result";
	}
}
