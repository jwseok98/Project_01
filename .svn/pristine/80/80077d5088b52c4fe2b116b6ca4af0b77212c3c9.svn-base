package sample.cwe494;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;

public class Consol_readLine_URLClassLoader {
	
	public void bad() throws Exception{
		
		InputStreamReader instrread = null;
		BufferedReader buffread = null;	
		
		String data = "";
		
		try {
			
			instrread = new InputStreamReader(System.in,"UTF-8");
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
	
}
