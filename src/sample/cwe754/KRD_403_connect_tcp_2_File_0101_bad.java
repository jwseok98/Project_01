package sample.cwe754;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;

public class KRD_403_connect_tcp_2_File_0101_bad {
	
	public void bad(){
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		BufferedReader br = null;
		FileReader fr = null;
		String data = "";
		
		try {			
			sock = new Socket("192.168.0.100",9000);
			
			instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
			if (data != null) {
				fr = new FileReader(data);
			}
			br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);		
			}
			
		} catch (Exception e) {
			//예외처리를 Exception으로 묶어서 처리하여 취약하다.
			IO.logger.log(Level.WARNING, "Unknown error occurred");
		}
		
	}
	
	public void bad2(){
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		BufferedReader br = null;
		FileReader fr = null;
		String data = "";

		try {	
			sock = new Socket("192.168.0.100",9000);
			
			instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
			if (data != null) {
				fr = new FileReader(data);
			}
			br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);		
			}
			
		} catch (IOException ie) {
			//   필요한 예외처리를 해준다.
			IO.logger.log(Level.WARNING, "Unknown error occurred");
		} 		
	}
	public void good1(){
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		BufferedReader br = null;
		FileReader fr = null;
		String data = "";

		try {	
			sock = new Socket("192.168.0.100",9000);
			
			instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
			if (data != null) {
				fr = new FileReader(data);
			}
			br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);		
			}
			
		} catch (java.net.UnknownHostException ie) {
			//   필요한 예외처리를 해준다.
			IO.logger.log(Level.WARNING, "Unknown error occurred");
		} catch (IOException ie) {
			//   필요한 예외처리를 해준다.
			IO.logger.log(Level.WARNING, "Unknown error occurred");
		} 		
	}
public void good2(){
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		BufferedReader br = null;
		FileReader fr = null;
		String data = "";

		try {	
			sock = new Socket("192.168.0.100",9000);
			
			instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
			if (data != null) {
				fr = new FileReader(data);
			}
			br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);		
			}
		}catch(java.io.FileNotFoundException ie){
			IO.logger.log(Level.WARNING, "Unknown error occurred");
		} catch (java.net.UnknownHostException ie) {
			//   필요한 예외처리를 해준다.
			IO.logger.log(Level.WARNING, "Unknown error occurred");
		}catch(java.io.UnsupportedEncodingException iaaa){
			IO.logger.log(Level.WARNING, "Unknown error occurred");			
		} catch (IOException ie) {
			//   필요한 예외처리를 해준다.
			IO.logger.log(Level.WARNING, "Unknown error occurred");	
		} catch(Exception e){
			IO.logger.log(Level.WARNING, "Unknown error occurred");
		}
		
	}
}
