package sample.cwe89;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	
	private Connection createConnection() throws SQLException {
		String dbUrl = "jdbc:postgresql://localhost/user";
		return DriverManager.getConnection(dbUrl, "postgres", "postgresp");
	}
	
	public void addUser(String userName, String userPassword, String userPhone, String userAddress) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		
		String query = "INSERT INTO USER (NAME, PASSWD, PHONE, ADDR) VALUES ('" + userName + "','" + userPassword + "','" + userPhone + "','" + userAddress + "')";
		try {
			conn = createConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch(SQLException sqle) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle) {
				}
			}
		}
	}
	
	public void addUser2(String userName, String userPassword, String userPhone, String userAddress) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
					
		String query = "INSERT INTO USER (NAME, PASSWD, PHONE, ADDR) VALUES ('" + userName + "','" + userPassword + "','" + userPhone + "','" + userAddress + "')";
		try {
			conn = createConnection();
			stmt = conn.createStatement();
			
			/* POTENTIAL FLAW */
			stmt.executeUpdate(query);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch(SQLException sqle) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle) {
				}
			}
		}
	}
	
	public void addUser2_good(String userName, String userPassword, String userPhone, String userAddress) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
				
		String query = "INSERT INTO USER (NAME, PASSWD, PHONE, ADDR) VALUES ('','','','')";
		try {
			conn = createConnection();
			stmt = conn.createStatement();
			
			/* FIX: 상수값 */
			stmt.executeUpdate(query);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch(SQLException sqle) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle) {
				}
			}
		}
	}
	
	public String getUserPassword(String userName) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "SELECT PASSWD FROM USER WHERE USERNAME='" + userName + "'";
		try {
			conn = createConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				return rs.getString(1);
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch(SQLException sqle) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch(SQLException sqle) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle) {
				}
			}
		}
		return null;
	}
	
	public String getUserPassword2(String userName) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "SELECT PASSWD FROM USER WHERE USERNAME='" + userName + "'";
		try {
			conn = createConnection();
			stmt = conn.createStatement();
			
			/* POTENTIAL FLAW */
			rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				return rs.getString(1);
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch(SQLException sqle) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch(SQLException sqle) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle) {
				}
			}
		}
		return null;
	}
	
	public String getUserPassword2_good(String userName) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String query = "SELECT PASSWD FROM USER WHERE USERNAME=''";
		try {
			conn = createConnection();
			stmt = conn.createStatement();
			
			/* FIX: 상수값 */
			rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				return rs.getString(1);
			}
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch(SQLException sqle) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch(SQLException sqle) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch(SQLException sqle) {
				}
			}
		}
		return null;
	}
}
