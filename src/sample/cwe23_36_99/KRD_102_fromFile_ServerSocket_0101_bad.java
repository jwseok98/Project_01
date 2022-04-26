package sample.cwe23_36_99;

import java.io.*;
import java.net.ServerSocket;

public class KRD_102_fromFile_ServerSocket_0101_bad {
	
	public void bad() throws Exception
	{
		String data;
		
		File f = new File("C:\\data.txt");
		
		BufferedReader buffread = null;
		FileInputStream fis = null;
		InputStreamReader instrread = null;
		

		
		try{			
			fis = new FileInputStream(f);
			instrread = new InputStreamReader(fis,"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();
			if(fis != null) fis.close();
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
