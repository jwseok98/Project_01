package sample.cwe674;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class KRD_302_Uncontrolled_Recursion__console_recursion_0101_bad {

	public long bad(long n)	
	{
			
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
			
		int num = 0;
			
		try {
						
			instrread = new InputStreamReader(System.in, "UTF-8");
			buffread = new BufferedReader(instrread);
				
			num = Integer.parseInt(buffread.readLine());
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (num < Integer.MAX_VALUE) {
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
