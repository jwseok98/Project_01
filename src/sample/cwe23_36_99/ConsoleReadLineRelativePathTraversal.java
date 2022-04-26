package sample.cwe23_36_99;

import java.io.*;

public class ConsoleReadLineRelativePathTraversal {
	
	public void bad() throws Exception
	{
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		String data = "";
		String root = "/usr/local/root";
		
		try{			
			instrread = new InputStreamReader(System.in, "UTF-8");
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
			//POTENTIAL FLAW
			File fIn = new File(root + data);
			
			if(fIn.exists() && fIn.isFile())
			{
				System.out.println(fIn.getAbsolutePath());
			}
		}
	}
}
