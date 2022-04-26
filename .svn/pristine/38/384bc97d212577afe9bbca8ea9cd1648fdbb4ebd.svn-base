package sample.cwe312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.PasswordAuthentication;
import java.net.ServerSocket;
import java.net.Socket;

public class Listen_tcp_passwordAuth {
	
	public void bad(){
		
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
		
		String [] datas = data.split("/");
		String password = datas[0];
		
		if (password != null) {
			PasswordAuthentication pa = new PasswordAuthentication("user", password.toCharArray());
			IO.writeLine(pa.toString());
		}
		
	}
	
}
