package sample.cwe312;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Environment_2_getConnection {
	
	public void bad(){
		
		String data;		
		Logger log2 = Logger.getLogger("local-logger");		
		data = System.getenv("ADD");	
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("192.168.105.23","sa",data);
		} catch (SQLException se) {
			log2.warning("errorgetting database connection");
		}
	}
	
}
