package sample.cwe23_36_99;

import java.net.*;
import java.io.*;

public class KRD_102_console_readLine_ServerSocket_0101_bad {
	
	public void bad() throws Exception
	{
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		String data = "";
		int port = 0;
		int def = 0;
		
		try{	
			instrread = new InputStreamReader(System.in,"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			port = Integer.parseInt(data);
			
			if(port == 1000)
			{
				def = 1000;
			}
			else
			{
				def = 1001;
			}
			
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();				
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
