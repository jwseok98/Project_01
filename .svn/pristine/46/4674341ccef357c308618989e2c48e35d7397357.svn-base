package sample.cwe539;

import java.net.HttpCookie;
import java.util.logging.Logger;

public class Enviroment_setMaxAge {
	
	public void bad(){
		String data;
		
		Logger log_bad = Logger.getLogger("local-logger");
		
		data = System.getenv("ADD");
		
		String name = "Name";
		String value = "ABC";
		HttpCookie hc = new HttpCookie(name, value);
		
		hc.setMaxAge(Integer.valueOf(data));
		System.out.println("Maximum age of the cookie is: "+hc.getMaxAge());
		
	}
	
}
