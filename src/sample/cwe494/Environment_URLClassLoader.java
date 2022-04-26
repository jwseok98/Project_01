package sample.cwe494;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Logger;

public class Environment_URLClassLoader {
	
	public void bad() throws Exception{		
		
		String data = "";
		
		Logger log_bad = Logger.getLogger("local-logger");
		
		data = System.getenv("add");
	
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
