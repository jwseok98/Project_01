package sample.cwe352;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class getParameterServlet_write {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		String data = request.getParameter("name");
		
    	// potential flaw
    	response.getWriter().write(data);
	}
    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		String data = "";
		
		{
			data = request.getParameter("name");
			
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
