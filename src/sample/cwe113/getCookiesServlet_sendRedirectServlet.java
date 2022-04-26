package sample.cwe113;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getCookiesServlet_sendRedirectServlet {
	
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String data = "";
		
		{
			Cookie cookieSources[] = request.getCookies();
			if(cookieSources != null)
			{
				data = cookieSources[0].getValue();
			}
		}
		
    	if(data != null)
    	{
    		// potential flaw
        	response.sendRedirect("/author.jsp?lang=" + data);
    	}    	
	}
}
