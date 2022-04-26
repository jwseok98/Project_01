package sample.dataflow.sqlinjection.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.dataflow.sqlinjection.UserDao;

public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6016752537796362241L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String userPassword = request.getParameter("password");
		
		boolean member = false;
		
		try {
			UserDao userDao = new UserDao();
			member = userDao.isMemberUser(userId, userPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (member) {
			HttpSession session = request.getSession();
			session.setAttribute("USERID", userId);
			session.setAttribute("ISLOGIN", true);
			
			response.sendRedirect("/main");
		} else {
			PrintWriter responseWriter = response.getWriter();
			responseWriter.println("로그인 실패");
			
			response.sendRedirect("/login");
		}
	}
}
