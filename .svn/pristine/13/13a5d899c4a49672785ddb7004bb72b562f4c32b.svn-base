package sample.dataflow.sqlinjection.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.dataflow.sqlinjection.UserDao;
import sample.dataflow.sqlinjection.UserDto;

public class UserMoreInfoServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6016752537796362241L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userid");
		
		UserDto userDto = null;
		
		try {
			UserDao userDao = new UserDao();
			userDto = userDao.getUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter writer = response.getWriter();
		
		if (userDto != null) {
			writer.println("유저정보");
			writer.println("이름: " + userDto.getUserName());
			writer.println("이메일: " + userDto.getUserEmail());
		} else {
			writer.println("유저를 찾을수 없습니다.");
		}
	}
}
