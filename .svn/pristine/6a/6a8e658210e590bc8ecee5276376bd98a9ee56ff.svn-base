package sample.cwe390;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connect_tcp_2_mkdirs {
	
	public void bad(){
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		
		String data = "";
		
		try {
			
			sock = new Socket("192.168.0.100",9000);
			
			instrread = new InputStreamReader(sock.getInputStream(),"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String dirs = data;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(dirs);
		} catch (FileNotFoundException fe) {
			// Exception catch 이후, Exception 에 대한 적절힌 처리가 없다.
		}
	}	
	
	public void good(){
			
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
			
		String data = "";			
		try {
				
			sock = new Socket("192.168.0.100",9000);
				
			instrread = new InputStreamReader(sock.getInputStream(),"UTF-8");
			buffread = new BufferedReader(instrread);
				
			data = buffread.readLine();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		String dirs = data;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(dirs);
		} catch (FileNotFoundException fe) {
			// Exception catch 이후, Exception 처리
			fe.printStackTrace();
		}
	}
	
	
}
