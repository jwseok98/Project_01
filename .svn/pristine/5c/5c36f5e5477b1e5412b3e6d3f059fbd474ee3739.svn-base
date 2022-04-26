package sample.cwe134;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class KRD_115_Uncontrolled_Format_String__URLConnection_format_0101_bad{
	public void bad() throws Exception
	{
		URL url = new URL("http://192.168.0.100/taint.html/");
		URLConnection con = url.openConnection();
		
		InputStream instream;
		BufferedReader buffread = null;
		InputStreamReader instrread = null;

		String data = "";
				
		try {
			instream = con.getInputStream();
			instrread = new InputStreamReader(instream , "utf-8");;
			buffread = new BufferedReader(instrread);

			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(data != null)
		{
			System.out.format(data);	
		}		
	}
}