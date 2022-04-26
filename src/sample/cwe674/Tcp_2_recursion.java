package sample.cwe674;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Tcp_2_recursion {

	public long bad(long n)	
	{
		
		Socket sock =null;
		
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		
		String data = "";
		
		try {
			
			sock = new Socket("192.168.0.100", 9000);
			
			instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
				
		} catch (Exception e) {
			e.printStackTrace();
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
