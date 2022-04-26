package sample.cwe330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

import sample.cwe539.IO;

public class Connect_tcp_2_Random {
	
	public void bad(){
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		
		String data = "";
		
		
		try {
			
			sock = new Socket("192.168.0.100", 9000);
			
			instrread = new InputStreamReader(sock.getInputStream(),"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Random rand = new Random();
		
		rand.setSeed(Integer.valueOf(data));
		IO.writeLine("Random int : " + rand.nextInt(100));
	}
	
}
