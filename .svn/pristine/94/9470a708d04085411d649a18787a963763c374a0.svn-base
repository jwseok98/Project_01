package sample.cwe285;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Improper_Authorization {

	public void bad(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String msgid = request.getParameter("msgid");
	
		KrdMessage msg = KrdUtil.LookupKrdMessageObject(msgid);	
		
		if(msg != null)
		{
			response.getWriter().println("From: " + msg.getUserName());
			response.getWriter().println("Subject: " + msg.getSubField());
			response.getWriter().println("Brom: " + msg.getBodyField());
		}
	}
}
