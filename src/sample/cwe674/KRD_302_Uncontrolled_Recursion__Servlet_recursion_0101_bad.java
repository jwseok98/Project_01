package sample.cwe674;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KRD_302_Uncontrolled_Recursion__Servlet_recursion_0101_bad {
	
	public long bad(HttpServletRequest request, HttpServletResponse response, int n) throws Throwable	
	{
	
		String data = request.getParameter("param");
			
		n = Integer.parseInt(data);
		
		if (n < Long.MAX_VALUE) {
			long ret = n + bad(request, response, n-1);
			return ret;
		}
		else
		{
			IO.writeLine("Input value is too large to perform.");
			return 0;
		}
	}
	public long good(HttpServletRequest request, HttpServletResponse response, int n) throws Throwable	
	{
		n = 1000;
		
		if (n < Long.MAX_VALUE) {
			long ret = n + bad(request, response, n-1);
			return ret;
		}
		else
		{
			IO.writeLine("Input value is too large to perform.");
			return 0;
		}
	}
}
