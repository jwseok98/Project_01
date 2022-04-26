package sample.cwe352;

import javax.servlet.http.*;

public class getCookiesServlet_write {
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
		
    	// potential flaw
    	response.getWriter().write(data);
	}
    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		String data = "";
		
		{
			Cookie cookieSources[] = request.getCookies();
			if(cookieSources != null)
			{
				data = cookieSources[0].getValue();
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
