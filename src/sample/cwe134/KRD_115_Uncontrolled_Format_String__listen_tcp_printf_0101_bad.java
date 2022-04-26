package sample.cwe134;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class KRD_115_Uncontrolled_Format_String__listen_tcp_printf_0101_bad {
	public void bad() throws Exception
	{
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

		if(data != null)
		{
			System.out.printf(data);	
		}		
	}
}