package sample.cwe674;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FromFile_2_recursion {
	public long bad(long n)	
	{
		File f = new File("C:\\data.txt");
		FileInputStream fis = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
			
		String data = "";
			
		try {
			
			fis = new FileInputStream(f);
			instrread = new InputStreamReader(fis, "UTF-8");
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
