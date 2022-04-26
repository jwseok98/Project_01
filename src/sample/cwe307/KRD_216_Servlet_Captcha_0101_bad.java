package sample.cwe307;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KRD_216_Servlet_Captcha_0101_bad {
	
	final static int MAX_ATTEMPTS = 5;
	
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		String username = "user1";
		String password = "star1234";
		
		if (username == null || password == null || !KrdUtil.isAuthenticatedUser(username,password)){
			response.getWriter().println("Invalid username, password<br/>");
			response.getWriter().println("<A href='/KRD_Debugging/"+
			"KRD_214_Improper_Restriction_Of_Excessive_Authentication_Attempts,htm'>Login Again</A></body></html>");
		}else{		
			response.getWriter().println(username + "has successfully logged in!");
		}		
	}
	public void good(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String username = "user1";
		String password = "star1234";		
		int count = 0;
		
		while(count < MAX_ATTEMPTS)
		{
			if (username == null || password == null || !KrdUtil.isAuthenticatedUser(username,password)){
				response.getWriter().println("Invalid username, password<br/>");
				response.getWriter().println("<A href='/KRD_Debugging/"+
				"KRD_214_Improper_Restriction_Of_Excessive_Authentication_Attempts,htm'>Login Again</A></body></html>");
			}else{		
				response.getWriter().println(username + "has successfully logged in!");
			}		
			count++;
		}		
	}	
}
