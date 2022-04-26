package sample.cwe312;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KRD_205_Servlet_setSecure_0101_bad {
	
	// 중요정보 평문저장
	
	public void bad(HttpServletRequest request, HttpServletResponse response){
		
		String data;
		
		data = "test";
		
		Cookie c = new Cookie("SecreatMessage", data);
		response.addCookie(c);		
	}
	public void good(HttpServletRequest request, HttpServletResponse response){
		
		String data;
		
		data = "test";
		
		Cookie c = new Cookie("SecreatMessage", data);
		c.setSecure(true);
		response.addCookie(c);		
	}
}
