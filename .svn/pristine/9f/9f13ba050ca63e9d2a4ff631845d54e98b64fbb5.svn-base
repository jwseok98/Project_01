package sample.cwe89_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSupportUtils {
	
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	private final static String connectionInfo = "jdbc:mysql:localhost/board";

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		loadJdbcDriver();
		return DriverManager.getConnection(connectionInfo, "mysql", "1q2w3e");
	}
	
	
	public static void loadJdbcDriver() throws ClassNotFoundException {
		Class.forName(jdbcDriver);
	}
	
}