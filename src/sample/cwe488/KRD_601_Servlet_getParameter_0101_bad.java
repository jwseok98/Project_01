package sample.cwe488;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KRD_601_Servlet_getParameter_0101_bad extends  HttpServlet {
	
	
	public String m_str_name;
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String data = "";
		m_str_name = request.getParameter(data);
		
		if (m_str_name != null) {
			response.getWriter().println("name : "+ m_str_name);
		}
			
	}
	
	public void good(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String data = "";
		
		
		String m_str_name = request.getParameter(data);
		
		if (m_str_name != null) {
			response.getWriter().println("name : "+ m_str_name);
		}
			
	}
	
	public static void main(String[] args) {
		boolean a = false;
		boolean b = false;
		
		System.out.println(a&&b);
		
	}
}
