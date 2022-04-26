package sample.cwe23_36_99;

import java.net.ServerSocket;

public class EnvironmentServerSocket {
	
	public void bad() throws Exception
	{
		String data = System.getenv("ADD");
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
