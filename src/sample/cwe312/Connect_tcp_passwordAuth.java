package sample.cwe312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.PasswordAuthentication;
import java.net.Socket;

public class Connect_tcp_passwordAuth {

	public void bad(){
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		String data = "";
		
		try {
			
			sock = new Socket("192.168.0.100",9000);
			
			instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
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
