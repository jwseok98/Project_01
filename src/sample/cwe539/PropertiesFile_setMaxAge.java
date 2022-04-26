package sample.cwe539;

import java.io.FileInputStream;
import java.net.HttpCookie;
import java.util.Properties;

public class PropertiesFile_setMaxAge {
	
	public void bad(){
		Properties props = new Properties();
		FileInputStream finstr = null;
		String data = "";
		
		try {
			String dir = System.getProperty("user.dir");
			finstr = new FileInputStream(dir +"/src/testcases/common/config.properties");
			
			props.load(finstr);
			
			data = props.getProperty("data");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String name = "Name";
		String value = "ABC";
		HttpCookie hc = new HttpCookie(name, value);
		
		
		hc.setMaxAge(Integer.valueOf(data));
		System.out.println("Maximum age of the cookie is: " + hc.getMaxAge());
		
	}
}
