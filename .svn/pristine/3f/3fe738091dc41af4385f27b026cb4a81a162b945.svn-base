package sample.cwe23_36_99;

import java.net.*;
import java.io.*;

public class ConnectTcpFile {
	
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
		
		try{
			File f1 = new File(data + "102-1.txt");
			File f2 = new File("C:\\102-2.txt");
			
			f1.renameTo(f2);
			
		}catch(Exception e){
			throw e;
		}
	}
	
	public void bad2() throws Exception
	{
		String data = "";
		
		try (Socket sock = new Socket("192.168.0.100", 9000); 
				InputStreamReader instrread = new InputStreamReader(sock.getInputStream(),"UTF-8");
				BufferedReader buffread = new BufferedReader(instrread)) 
		{
			
			data = buffread.readLine();
			
		}
		
		try{
			File f1 = new File(data + "102-1.txt");
			File f2 = new File("C:\\102-2.txt");
			
			f1.renameTo(f2);
			
		}catch(Exception e){
			throw e;
		}
	}
}
