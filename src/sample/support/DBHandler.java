/**
 * Mockup Class
 */
package sample.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {
	
	public DBHandler(Object caller) {
		this(caller, null);
	}
	
	public DBHandler(String m_dbName) {
		this(null, m_dbName);
	}
	
	public DBHandler(Object caller, String m_dbName) {
		
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = DriverManager.getConnection("");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		
		return rs;
	}
	
	public void end() {
		
	}
}