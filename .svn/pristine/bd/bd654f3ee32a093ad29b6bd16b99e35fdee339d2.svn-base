package sample.cwe312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class KRD_206_connect_tcp_2_getConnection_0101_bad {
	
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
		Logger log2 = Logger.getLogger("local-logger");
		
		try {
			con = DriverManager.getConnection("192.168.15.23","sa",data);
		} catch (SQLException se) {
			log2.warning("error getting database connection");
		}
		
	}
}
