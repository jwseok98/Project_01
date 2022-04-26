package sample.cwe674;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Console_readLine_2_recursion {

	public long bad(long n)	
	{
			
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
			
		String data = "";
			
		try {
						
			instrread = new InputStreamReader(System.in, "UTF-8");
			buffread = new BufferedReader(instrread);
				
			data = buffread.readLine();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		n = Long.parseLong(data);
		
		if (n < Long.MAX_VALUE) {
			long ret = n + bad(n-1);
			return ret;
		}
		else
		{
			IO.writeLine("Input value is too large to perform.");
			return 0;
		}
	}

}
