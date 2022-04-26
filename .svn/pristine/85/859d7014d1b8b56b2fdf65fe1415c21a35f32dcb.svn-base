package sample.cwe89;

public class UserService {
	
	public void addUser(String userName, String userPassword, String userPhone, String userAddress) throws Exception {
		UserDao userDao = new UserDao();
		
		userDao.addUser(userName, userPassword, userPhone, userAddress);
	}
	
	public String getUserPassword(String userName) throws Exception {
		UserDao userDao = new UserDao();
		
		String userPassword = userDao.getUserPassword(userName);
		return userPassword;
	}
}
