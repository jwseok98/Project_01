package sample.cwe312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Console_readLine_2_getConnection {
	
	public void bad(){
		
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		String data = "";
			
		try {
				
			instrread = new InputStreamReader(System.in, "UTF-8");
			buffread = new BufferedReader(instrread);			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		Logger log2 = Logger.getLogger("local-logger");
		
		try {
			con = DriverManager.getConnection("192.168.105.23","sa",data);			
			
		} catch (SQLException se) {
			log2.warning("error getting database connection");
		}
		
	}
}
