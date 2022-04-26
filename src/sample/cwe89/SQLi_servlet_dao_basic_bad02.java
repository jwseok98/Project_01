/*
 * 참조: 행정안전부 SW개발보안가이드 - SQL삽입 - 안전하지않은코드
 */
package sample.cwe89;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class SQLi_servlet_dao_basic_bad02 extends HttpServlet {
	
	private static final long serialVersionUID = -2642576670596248077L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String userPassword = "";
		
		UserDao userDao = new UserDao();
		
		try {
			/* POTENTIAL FLAW: 연관분석 적용 */
			userPassword = userDao.getUserPassword(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.getWriter().println(userPassword);
	}	
}
