package sample.cwe307;

public class KrdUtil {
	public static boolean isAuthenticatedUser(String username,String password){
		
		if (username != null || password != null) {
			return false;
		}
		return true;
	}
}
