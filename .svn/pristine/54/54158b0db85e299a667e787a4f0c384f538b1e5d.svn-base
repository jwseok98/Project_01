package sample.cwe488;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KISA_KRD_601_Exposure_of_Data_Element_to_Wrong_Session__Servlet_getParameter_0101_good extends AbstractTestCaseServlet {
	
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String data;
		
		data = "name";
	
		 /* FLAW */        
        String m_str_name = request.getParameter(data);
        if (m_str_name != null) {
            response.getWriter().println("name: " + m_str_name);
        }
	}
}