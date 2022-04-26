package sample.cwe352;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class getQueryStringServlet_write {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String data = "";
    	
    	{
    		StringTokenizer st = new StringTokenizer(request.getQueryString(),"&");
    		
    		while(st.hasMoreTokens())
    		{
    			String token = st.nextToken();
    			if(token.startsWith("id="))
    			{
    				data = token.substring(3);
    				break;
    			}
    		}
    	}		
		
    	// potential flaw
    	response.getWriter().write(data);
	}
    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		String data = "";
		
		{
    		StringTokenizer st = new StringTokenizer(request.getQueryString(),"&");
    		
    		while(st.hasMoreTokens())
    		{
    			String token = st.nextToken();
    			if(token.startsWith("id="))
    			{
    				data = token.substring(3);
    				break;
    			}
    		}
			
			HttpSession session = request.getSession(true);			
			String trustedToken = (String)session.getAttribute("token");
			
			if(request.getParameter("token") == null || !request.getParameter("token").equals(trustedToken))
			{
				return;
			}
		}
		
    	// potential flaw
    	response.getWriter().write(data);
	}
}
