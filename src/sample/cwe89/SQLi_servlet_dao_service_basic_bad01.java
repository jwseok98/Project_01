/*
 * 참조: 행정안전부 SW개발보안가이드 - SQL삽입 - 안전하지않은코드
 */
package sample.cwe89;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class SQLi_servlet_dao_service_basic_bad01 extends HttpServlet {
	
	private static final long serialVersionUID = -6467800071672997227L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("userpasswd");
		String userPhone = request.getParameter("userphone");
		String userAddress = request.getParameter("useraddr");
		
		UserService userService = new UserService();
		
		try {
			/* POTENTIAL FLAW: 연관분석 적용 */ 
			userService.addUser(userName, userPassword, userPhone, userAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}