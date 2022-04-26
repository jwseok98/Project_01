package sample.cwe539;

import java.net.HttpCookie;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetParameterServlet_setMaxage {
	public void bad(HttpServletRequest request, HttpServletResponse response){
		String data;
		Logger log_bad = Logger.getLogger("local-logger");
		
		data = request.getParameter("name");
		
		String name = "Name";
		String value = "ABC";
		HttpCookie hc = new HttpCookie(name, value);
		
		
		hc.setMaxAge(Integer.valueOf(data));
		System.out.println("Maximum age of the cookie is: " + hc.getMaxAge());
		
	}
}
