package sample.dataflow.sqlinjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	
	public boolean isMemberUser(String userId, String userPassword) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection("", "", "");
			
			stmt = conn.createStatement();
			
			String query = "SELECT U_PASSWORD FROM T_USER WHERE U_ID=" + userId;
			
			// POTENTIAL FLAW
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String storedPassword = rs.getString(1);
				
				if (storedPassword.equals(userPassword)) {
					return true;
				}
			}
		} finally {
			JdbcUtils.close(conn, stmt, rs);
		}
		return false;
	}
	
	public boolean isMemberUser_Temp(String userId, String userPassword) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection("", "", "");
			
			stmt = conn.createStatement();
			
			String query = "SELECT U_PASSWORD FROM T_USER WHERE U_ID=" + userId;
			
			// POTENTIAL FLAW
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String storedPassword = rs.getString(1);
				
				if (storedPassword.equals(userPassword)) {
					return true;
				}
			}
		} finally {
			JdbcUtils.close(conn, stmt, rs);
		}
		return false;
	}
	
	public UserDto getUser(String userId) throws ClassNotFoundException, SQLException {		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection("", "", "");
			
			stmt = conn.createStatement();
			
			String query = "SELECT * FROM T_USER WHERE U_ID = " + userId;
			
			// POTENTIAL FLAW
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setUserId(userId);
				userDto.setUserName(rs.getString("U_NAME"));
				userDto.setUserEmail(rs.getString("U_EMAIL"));
				return userDto;
			}
		} finally {
			JdbcUtils.close(conn, stmt, rs);
		}
		return null;		
	}
}
