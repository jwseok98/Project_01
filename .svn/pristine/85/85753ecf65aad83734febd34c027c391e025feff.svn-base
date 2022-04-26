package sample.cwe23_36_99;

import java.io.*;

public class Console_readLine_File {
	
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
				
		try{
			File f1 = new File(data + "102-1.txt");
			File f2 = new File("C:\\102-2.txt");
			
			f1.renameTo(f2);
			
		}catch(Exception e){
			throw e;
		}
	}
}
