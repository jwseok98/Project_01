package sample.cwe539;

import java.net.HttpCookie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FromDB_setMaxAge {
	
	public void bad(){
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String data = "";
		
		try {
			con = IO.getDBConnection();
			
			statement = con.prepareStatement("select name from users where id=0");
			rs = statement.executeQuery();
			rs.next();
			
			data = rs.getString(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String name = "Name";
		String value = "ABC";
		HttpCookie hc = new HttpCookie(name, value);
		
		hc.setMaxAge(Integer.valueOf(data));
		System.out.println("Maximum age of the cookie is: "+hc.getMaxAge());
	}
}
