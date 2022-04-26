package sample.cwe113;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getQueryStringServlet_sendRedirect {
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
		
    	if(data != null)
    	{
    		// potential flaw
        	response.sendRedirect("/author.jsp?lang=" + data);
    	}    	
	}
}
