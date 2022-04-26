package sample.cwe23_36_99;

import java.io.*;

public class ConsoleReadLineAbsolutePathTraversal {
	
	public void bad() throws Exception
	{
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		String data = "";
		
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
		
		try{
			File f1 = new File(data);
			File f2 = new File("C:\\102-2.txt");
			
			f1.renameTo(f2);
			
			File f3 = new File(data + "102-1.txt");
			File f4 = new File("C:\\102-2.txt");
			
			f3.renameTo(f4);
			
		}catch(Exception e){
			throw e;
		}
	}
}
