package sample.cwe807;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet_basic_equals {
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		String userRole = "";
		
    	Cookie [] cookies = request.getCookies(); 	    	
    	
    	for(int i=0; i<cookies.length; i++)
    	{
    		Cookie c = cookies[i];
    		
    		if(c.getName().equals("role"))
    		{
    			userRole = c.getValue();
    		}
    	}
    	System.out.println("login ok " + userRole);
	}
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	HttpSession c = request.getSession();
    	String userRole = "";
    	userRole = (String)c.getAttribute("userRole");
		
		System.out.println("login ok " + userRole);
	}
}
