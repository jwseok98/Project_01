package sample.cwe312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class URLConnection_driverManager {
	
	public void bad() throws Exception{
		
		URLConnection conn = (new URL("http://192.168.0.100/taint.html/")).openConnection();
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		String data = "";
		
		try {
					
			instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Connection conn2 = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String [] datas = data.split("/");
		String password = datas[0];
		
		try {
			
			conn2 = DriverManager.getConnection("data-url","root",password);
			st = conn2.prepareStatement("select * from test_table");
			rs = st.executeQuery();
			
		} catch (SQLException se) {
			IO.logger.log(Level.WARNING,"Error with database connection", se);
			
		}
	}
}
