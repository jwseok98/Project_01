package sample.cwe494;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;


public class FromFile_URLClassLoader {

	
	public void bad() throws Exception{
		
		File f = new File("c:\\data/txt");
		BufferedReader buffread = null;
		FileInputStream fis = null;
		InputStreamReader isread = null;
		
		String data = "";
		
		try {
			
			fis = new FileInputStream(f);
			isread = new InputStreamReader(fis, "UTF-8");
			buffread = new BufferedReader(isread);
				
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
