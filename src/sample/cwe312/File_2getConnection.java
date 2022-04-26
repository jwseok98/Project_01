package sample.cwe312;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class File_2getConnection {
	
	public void bad(){
		
		File f = new File("C:\\data.txt");
		BufferedReader buffread = null;
		FileInputStream fis = null;
		InputStreamReader isread = null;
		String data = "";		
		
		try {
			
			fis = new FileInputStream(f);
			isread = new InputStreamReader(fis, "UTF-8");
			buffread = new BufferedReader(isread);
			
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
