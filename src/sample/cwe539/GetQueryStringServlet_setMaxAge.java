package sample.cwe539;


import java.net.HttpCookie;
import java.util.StringTokenizer;

import javax.servlet.http.*;

public class GetQueryStringServlet_setMaxAge {
	public void bad(HttpServletRequest request, HttpServletResponse response){
		String data = "";
		{
			StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
			while(st.hasMoreTokens())
			{
				String token = st.nextToken();
				if (token.startsWith("id=")) {
					data = token.substring(3);
					break;
				}
				
			}
		}
		
		String name = "Name";
		String value = "ABC";
		HttpCookie hc = new HttpCookie(name, value);
		
		
		hc.setMaxAge(Integer.valueOf(data));
		System.out.println("Maximum age of the cookie is: " + hc.getMaxAge());
		
	}
}
