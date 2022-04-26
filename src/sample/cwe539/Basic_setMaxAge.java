package sample.cwe539;

import java.net.HttpCookie;

public class Basic_setMaxAge {
	
	public void bad(){
		
		String name = "Name";
		String value = "ABC";
		HttpCookie hc = new HttpCookie(name, value);
		
		hc.setMaxAge(60*60*24*7);
		System.out.println("Maximum age of the cookie is : " + hc.getMaxAge());
	}
	
}
