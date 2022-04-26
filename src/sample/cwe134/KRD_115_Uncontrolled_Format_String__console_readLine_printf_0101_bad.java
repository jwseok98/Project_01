package sample.cwe134;

import java.io.*;

public class KRD_115_Uncontrolled_Format_String__console_readLine_printf_0101_bad  {
	
	public void bad() throws Exception
	{
		
		String data = "";
		
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		try{	
			instrread = new InputStreamReader(System.in,"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();				
		}

		if(data != null)
		{
			System.out.printf(data);	
		}		
	}
}
