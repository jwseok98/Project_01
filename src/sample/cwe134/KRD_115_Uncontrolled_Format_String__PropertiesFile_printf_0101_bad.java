package sample.cwe134;

import java.io.*;
import java.util.Properties;

public class KRD_115_Uncontrolled_Format_String__PropertiesFile_printf_0101_bad{
	public void bad() throws Exception
	{
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

		if(data != null)
		{
			System.out.printf(data);	
		}		
	}
}