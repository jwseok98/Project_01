package sample.cwe489;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Servlet_getParameter {
	
	public void bad(){
		
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		Socket sock = null;
		
		String data = "";
		try {
			
			sock = new Socket();
			instrread = new InputStreamReader(sock.getInputStream()); 
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
			// 디버깅용 코드
			System.out.println("Debugging...data:" + data);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void good(){
		
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		Socket sock = null;
		
		String data = "";
		
		try {
			
			sock = new Socket();
			instrread = new InputStreamReader(sock.getInputStream()); 
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
			// 디버깅용 코드 제거한다.
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
