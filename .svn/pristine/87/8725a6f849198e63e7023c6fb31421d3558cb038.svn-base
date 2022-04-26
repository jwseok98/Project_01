package sample.cwe489;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class KRD_602_Servlet_equals_0101_bad {
	

	public void bad(HttpServletRequest request, HttpServletResponse response){
		
		
		String data = "ok";
		HttpSession session = request.getSession();
		boolean isAuthenticated;
		
		
		// 디버깅 라인이 제거되지 않아 취약하다
		if (request.getParameter("debug") != null && request.getParameter("debug").equals(data)) {
			session.setAttribute("username","admin");
			session.setAttribute("isAdmin","true");
		    isAuthenticated = true;
			
		}
	}
	
	public void good(HttpServletRequest request, HttpServletResponse response){
		
		
		String data = "ok";
		HttpSession session = request.getSession();
		boolean isAuthenticated;
		
		// 디버깅 라인을 제거해준다
		session.setAttribute("username","admin");
		session.setAttribute("isAdmin","true");
		isAuthenticated = true;
			
		
	}
	
}
