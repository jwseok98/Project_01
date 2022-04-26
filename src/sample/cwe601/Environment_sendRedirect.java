package sample.cwe601;

import java.net.*;

import javax.servlet.http.*;

public class Environment_sendRedirect {
	
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		String data = System.getenv("ADD");
		
		try{
			URI u = new URI(data);
			System.out.println(u.getPath());
			
		}catch(URISyntaxException e){
			response.getWriter();
			return;
		}
				
		response.sendRedirect(data);		
	}
}
