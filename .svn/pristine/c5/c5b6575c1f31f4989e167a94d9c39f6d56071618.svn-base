package sample.cwe89_3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2455296320002109194L;
	
	private static final BoardService service = new BoardService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operation = getParameter(request, "operarion");
		
		if (operation.isEmpty()) {
			response.sendRedirect("/error/invalid_param");
			return;
		}
		
		if (operation.equals("remove")) {
			
			// tainted value
			String title = getParameter(request, "title");
			
			if (title.isEmpty()) {
				response.sendRedirect("/error/invalid_param");
				return;
			}
			
			try {
				// input
				service.remove(title);
			} catch (ServiceException se) {
				se.printStackTrace();
			}
		} else if (operation.equals("remove2")) {
			
			// tainted value
			String title = request.getParameter("title");
			
			if (title.isEmpty()) {
				response.sendRedirect("/error/invalid_param");
				return;
			}
			
			try {
				// input
				service.remove2(title);
			} catch (ServiceException se) {
				se.printStackTrace();
			}
		}
	}
	
	private String getParameter(HttpServletRequest request, String paramName) {
		return request.getParameter(paramName) != null ? request.getParameter(paramName) : ""; 
	}
	
}
