package sample.cwe539;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.net.*;

public class Listen_tcp_setMaxAge {
	public void bad(){
		
		 Socket sock = null;
         BufferedReader buffread = null;
         InputStreamReader instrread = null;
         ServerSocket listener = null;
         String data = "";
		
		try {
			listener = new ServerSocket(9000);
			sock  = listener.accept();
			
			instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			data = buffread.readLine();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String name = "Name";
		String value = "ABC";
		HttpCookie hc = new HttpCookie(name, value);
		
		
		hc.setMaxAge(Integer.valueOf(data));
		System.out.println("Maximum age of the cookie is: " + hc.getMaxAge());
		
	}
}
