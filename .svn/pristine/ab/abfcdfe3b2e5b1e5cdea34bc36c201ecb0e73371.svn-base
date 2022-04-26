package sample.cwe312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class Listen_tcp_driverManager {
	public void bad(){
		
		ServerSocket listener = null;
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		String data = "";
		
		try {
			
			listener = new ServerSocket(9000);
			sock = listener.accept();
			
			instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String [] datas = data.split("/");
		String password = datas[0];
		
		try {
			
			con = DriverManager.getConnection("data-url","root",password);
			st = con.prepareStatement("select * from test_table");
			rs = st.executeQuery();
			
		} catch (SQLException se) {
			IO.logger.log(Level.WARNING,"Error with database connection", se);
			
		}
	}
}
