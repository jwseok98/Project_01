/*
 * 참조: 없음. 스프링 MVC 기반 샘플 - XQuery 삽입
 */
package sample.cwe652.spring;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CWE652_xqi_spring_basic_bad01 {
	
	@ResponseBody
	@RequestMapping(value="/viewAuthInfo")
	public String viewAuthInfo(String userName) throws Exception {
		
		String es = "doc('users.xml')/userlist/user[uname='" +userName + "']"; 
		
		XQConnection conn = new XQConnectionImpl();
		
		// POTENTIAL FLAW
		XQPreparedExpression expr = conn.prepareExpression(es);
		XQResultSequence result = expr.executeQuery();
		
		while (result.next()) {
			String str = result.getAtomicValue();
			if (str.indexOf(">") < 0) {
				return str;
			}
		}
		return "no result";
	}
}
