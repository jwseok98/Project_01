package sample.cwe674;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class KRD_302_Uncontrolled_Recursion__connect_tcp_2_recursion_0101_bad {
	
	public long bad(long n)	throws Exception 
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
			sample.cwe.logger.Logger.writeLine(e.getMessage());
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();				
			if(sock != null) sock.close();
		}
		
		n = Long.parseLong(data);
		
		if (n < Long.MAX_VALUE) {
			long ret = n + bad(n-1);
			return ret;
		}
		else
		{
			IO.writeLine("Input value is too large to perform.");
			return 0;
		}
	}

}
