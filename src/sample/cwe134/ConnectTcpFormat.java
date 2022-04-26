package sample.cwe134;

import java.net.*;
import java.io.*;

public class ConnectTcpFormat {
	
	public void bad() throws Exception
	{
		Socket sock = null;
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		String data = "";
		
		try{
			sock = new Socket("192.168.0.100", 9000);			
			instrread = new InputStreamReader(sock.getInputStream(),"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();				
			if(sock != null) sock.close();
		}
		
		if(data != null)
		{
			System.out.format(data);	
		}		
	}
}
