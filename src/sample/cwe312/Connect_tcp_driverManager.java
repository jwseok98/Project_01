package sample.cwe312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Connect_tcp_driverManager {
	
	public void bad(){
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		String data = "";
			
		try {
			
			sock = new Socket("192.168.0.100",9000);
			
			instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Logger log2 = Logger.getLogger("local-logger");
		String [] datas = data.split("/");
		String password = datas[0];
		
		try {
			con = DriverManager.getConnection("data-url","root",password);
			st = con.prepareStatement("select * from test_table");
			rs = st.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getString("userid"));
			}
			
		} catch (SQLException se) {
			log2.warning("error getting database connection");
		}
		
	}
	
}
