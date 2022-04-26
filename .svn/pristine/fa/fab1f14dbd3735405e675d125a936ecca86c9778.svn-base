package sample.cwe134;

import java.io.*;

public class KRD_115_Uncontrolled_Format_String_fromFile_format_bad {
	public void bad() throws Exception
	{
		String data;
		
		BufferedReader buffread = null;
		FileInputStream fis = null;
		InputStreamReader instrread = null;		
		
		try{		
			File f = new File("C:\\data.txt");
			fis = new FileInputStream(f);
			instrread = new InputStreamReader(fis,"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();
			if(fis != null) fis.close();
		}

		if(data != null)
		{
			System.out.format(data);	
		}		
	}
}