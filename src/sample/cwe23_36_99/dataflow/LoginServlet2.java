package sample.cwe23_36_99.dataflow;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet2 extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6016752537796362241L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String userpasswd = request.getParameter("password");
		
		boolean successLogin = false;
		
		try {
			LoginDao loginDao = new LoginDao();
			successLogin = loginDao.login(userid, userpasswd);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		if (successLogin) {
			System.out.println("success login");
		} else {
			System.out.println("failed login");
		}
	}
}
