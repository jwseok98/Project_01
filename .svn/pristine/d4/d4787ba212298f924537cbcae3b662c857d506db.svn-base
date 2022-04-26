package sample.cwe539;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpCookie;

public class Console_readLine_setMaxAge {
	
	public void bad(){
		
		String data = "";
		
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		try {
			instrread = new InputStreamReader(System.in, "UTF-8");
			buffread = new BufferedReader(instrread);
			data = buffread.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String name = "name";
		String value = "ABC";
		HttpCookie hc = new HttpCookie(name, value);
		
		hc.setMaxAge(Integer.valueOf(data));
		System.out.println("Maximum age of cookie is : "+ hc.getMaxAge());
	}
}
