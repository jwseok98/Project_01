package sample.cwe539;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.net.Socket;

public class Connect_tcp_setMaxAge {
	
	public void bad(){
		
		Socket sock = null;
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
		
		String name = "Name";
		String value = "ABC";
		HttpCookie hc = new HttpCookie(name, value);
		
		hc.setMaxAge(Integer.valueOf(data));
		System.out.println("Maximum age of the cookie is : "+ hc.getMaxAge());
			
	}
}
