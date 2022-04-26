package sample.cwe23_36_99.dataflow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	
	public boolean login(String userid, String userpasswd) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("");
			stmt = conn.createStatement();
			
			String query = "SELECT U_PASSWORD FROM T_USER WHERE U_ID=" + userid;
			
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String storedPassword = rs.getString(1);
				
				if (storedPassword.equals(userpasswd)) {
					return true;
				}
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			
			if (stmt != null) {
				stmt.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		}
		return false;
	}

}
