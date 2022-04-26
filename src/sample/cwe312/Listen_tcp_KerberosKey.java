package sample.cwe312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;



import javax.security.auth.kerberos.KerberosKey;
import javax.security.auth.kerberos.KerberosPrincipal;

public class Listen_tcp_KerberosKey {
	
	public void bad(){
		
		String data = "";
		
		ServerSocket listener = null;
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		
		
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
			KerberosPrincipal principal = new KerberosPrincipal("test");
			
			KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
			IO.writeLine(key.toString());
		}
		
		
	}
	
}
