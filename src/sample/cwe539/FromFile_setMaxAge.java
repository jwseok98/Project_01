package sample.cwe539;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpCookie;

public class FromFile_setMaxAge {
	
	public void bad(){
		
		File f = new File("C:\\data.txt");
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
		
		String name = "Name";
		String value = "ABC";
		HttpCookie hc = new HttpCookie(name, value);
		
		hc.setMaxAge(Integer.valueOf(data));
		System.out.println("Maximum age of the cookie is: "+hc.getMaxAge());
				
	}
	
}
