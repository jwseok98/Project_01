package sample.cwe247;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class Security_Decision {
	
	public void bad() throws UnknownHostException{
		
		String data;
		// data 가 도메인으로 하드코딩 되어있어 취약하다
		data = "adtest.com"; 
		
		Logger log_bad = Logger.getLogger("local-logger");
		InetAddress giriAddress = java.net.InetAddress.getByName(data);
		data = giriAddress.getHostAddress();
		Socket sock = null;
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		try {
			
			sock = new Socket(data, 9000);
			
			instrread = new InputStreamReader(sock.getInputStream());
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void good() throws UnknownHostException{
		
		String data;
		// data 에 IP주소를 넣어준다.
		data = "192.168.0.100"; 
		
		Logger log_bad = Logger.getLogger("local-logger");
		Socket sock = null;
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		try {
			
			sock = new Socket(data, 9000);
			
			instrread = new InputStreamReader(sock.getInputStream());
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
