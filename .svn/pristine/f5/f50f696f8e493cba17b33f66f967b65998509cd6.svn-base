package sample.cwe494;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class FromDB_URLClassLoader {
	
	public void bad() throws Exception{
		
		Connection conn = null;	
		PreparedStatement statement = null;
		ResultSet rs = null;
		String data = "";
		
		try {
			
			conn = IO.getDBConnection();
			
			statement = conn.prepareStatement("select name from users where id =0");
			rs = statement.executeQuery();
			rs.next();
			
			
			data = rs.getString(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		URLClassLoader ucl = null;
		URL classUrl = new URL(data);
		URL[] classUrls = {classUrl};	
		
		try {
			ucl = new URLClassLoader(classUrls);
			Class c = ucl.loadClass("org.apache.commons.lang.ArrayUtils");
			for (Field fld : c.getDeclaredFields()) {
				System.out.println("Field name "+fld.getName());
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		
	}
}
