package sample.cwe674;

import java.util.logging.Logger;

public class Environment_2_recursion {
	
	public long bad(long n)	
	{
					
		String data = "";
		Logger log_bad = Logger.getLogger("local-logger");
		
		data = System.getenv("ADD");
	
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
