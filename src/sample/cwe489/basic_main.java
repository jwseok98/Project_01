package sample.cwe489;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class basic_main {
	
	public void good(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String data = "";
		
		// ���������� �����Ѵ�.
		String m_str_name = request.getParameter(data);
		
		if (m_str_name != null) {
			response.getWriter().println("name : "+ m_str_name);
		}
			
	}
	
	public static void main(String [] args)
	{
		System.out.print("helo");
	}
}
