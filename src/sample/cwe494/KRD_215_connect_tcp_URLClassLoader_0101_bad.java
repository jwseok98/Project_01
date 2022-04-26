package sample.cwe494;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;

public class KRD_215_connect_tcp_URLClassLoader_0101_bad {
	
	public void bad() throws Exception{
		
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		Socket sock = null;		
		
		String data = "";
		
		try {
			sock = new Socket("192.168.1.1",19003);
			instrread = new InputStreamReader(sock.getInputStream(),"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		URLClassLoader ucl = null;
		URL classUrl = new URL(data);
		URL[] classUrls = {classUrl};	
		
		try {
			ucl = new URLClassLoader(classUrls);
			
			Class c = ucl.loadClass("org.apache.commons.lang.ArrayUtils");
			for (Field fld : c.getDeclaredFields()) {
				System.out.println("Field name "+fld.getName());
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}		
	}
	public void good() throws Exception
	{		
		String data = "www.evenstar.co.kr";			
		
		URLClassLoader ucl = null;
		URL classUrl = new URL(data);
		URL[] classUrls = {classUrl};	
		
		try {
			ucl = new URLClassLoader(classUrls);
			
			Class c = ucl.loadClass("org.apache.commons.lang.ArrayUtils");
			for (Field fld : c.getDeclaredFields()) {
				System.out.println("Field name "+fld.getName());
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}		
	}
}
