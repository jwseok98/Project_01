package sample.cwe807;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class Servlet_authenticated_equals {
	
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	Cookie [] cookies = request.getCookies(); 	
    	boolean authenticated = false;
    	
    	for(int i=0; i<cookies.length; i++)
    	{
    		Cookie c = cookies[i];
    		
    		if(c.getName().equals("authenticated") && Boolean.TRUE.equals(c.getValue()))
    		{
    			authenticated = true;
    		}
    	}
    	
    	if(authenticated)
    	{
    		System.out.println("login ok");
    	}
	}
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	HttpSession c = request.getSession();
    	boolean authenticated = false;    	   
		
		if(Boolean.TRUE.equals(c.getAttribute("authenticated")))
		{
			authenticated = true;
		}
		
		if(authenticated)
    	{
    		System.out.println("login ok");
    	}
	}
}
