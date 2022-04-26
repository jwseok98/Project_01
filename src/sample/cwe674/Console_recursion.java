package sample.cwe674;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console_recursion {
	public long bad(long n)	
	{
			
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
			
		int data = 0;
			
		try {
						
			instrread = new InputStreamReader(System.in, "UTF-8");
			buffread = new BufferedReader(instrread);
				
			
			try {
				data = Integer.parseInt(buffread.readLine());
			} catch (Exception ee) {
				ee.printStackTrace();
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		n = data;
		
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
