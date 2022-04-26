package sample.cwe312;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesFile_getCnnection {
	
	public void bad(){
		
		Properties props = new Properties();
		FileInputStream finstr = null;
		
		String data = "";
		Logger log2 = Logger.getLogger("local-logger");
		try {
			
			String dir = System.getProperty("user.dir");
			finstr = new FileInputStream(dir+"/stc/testcases/common/config.properties");
			
			props.load(finstr);
	        
			data = props.getProperty("data");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Connection con2 =null;
		
		try {
			con2 = DriverManager.getConnection("192.168.105.23","sa",data);
		} catch (Exception e) {
			log2.warning("error getting database connection");
		}
		
	}
	
}
