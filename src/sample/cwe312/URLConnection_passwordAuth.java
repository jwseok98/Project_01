package sample.cwe312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

public class URLConnection_passwordAuth {
	
	public void bad() throws Exception{
		
		URLConnection conn = (new URL("http://192.168.0.100/taint.html/")).openConnection();
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		String data = "";
		
		try {
					
			instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String [] datas = data.split("/");
		String password = datas[0];
		
		if (password != null) {
			PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
			IO.writeLine(pa.toString());
		}
		
	}
}
