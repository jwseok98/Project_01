package sample.cwe23_36_99;

import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FromDbServerSocket {
	
	public void bad() throws Exception
	{
		String data = "";
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
					
		try{
			con = IO.getDBConnection();
			statement = con.prepareStatement("select * from tuser");
			rs = statement.executeQuery();
			rs.next();
			
			data = rs.getString(1);
		}catch(Exception e){
			throw e;
		}finally{
			if(rs != null) con.close();
			if(statement != null) con.close();
			if(con != null) con.close();
		}
		
		int port = Integer.parseInt(data);
		int def = 0;
		
		if(port == 1000)
		{
			def = 1000;
		}
		else
		{
			def = 1001;
		}
		
		ServerSocket serverSock = null;
		
		try{
			if(port != 0)
			{
				serverSock = new ServerSocket(port + 3000);
			}
			else
			{
				serverSock = new ServerSocket(def + 3000);
			}
			
			serverSock.accept();
			
		}catch(Exception e){
			throw e;
		}finally{
			if(serverSock != null)
			{
				serverSock.close();
			}
		}
	}
}
