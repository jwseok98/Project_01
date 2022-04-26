package sample.dataflow.sqlinjection.spf;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.dataflow.sqlinjection.UserDao;
import sample.dataflow.sqlinjection.UserDto;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public boolean login(HttpServletRequest request, String userId, String userPassword) throws UserServiceException {
		boolean member = false;

		try {
			member = userDao.isMemberUser(userId, userPassword);
		} catch (Exception e) {
			throw new UserServiceException("", e);
		}

		if (member) {
			HttpSession session = request.getSession();
			session.setAttribute("USERID", userId);
			session.setAttribute("ISLOGIN", true);
		}
		return member;
	}
	
	public UserDto getUser(String userId) throws UserServiceException {
		UserDto userDto = null;
		
		try {
			userDto = userDao.getUser(userId);; 
		} catch (Exception e) {
			throw new UserServiceException("", e);
		}
		return userDto;
	}
}
