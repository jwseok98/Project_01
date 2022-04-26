package sample.dataflow.sqlinjection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	
	public static Connection getConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void close(Connection connection) {
		close(connection, null, null);
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultset) {
		if (resultset != null) {
			try {
				resultset.close();
			} catch (SQLException sqle) {
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException sqle) {
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqle) {
			}
		}
	}
}
