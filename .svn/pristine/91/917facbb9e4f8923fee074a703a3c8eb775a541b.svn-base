package sample.cwe23_36_99;

import java.io.*;

public class FromFileFile {
	
	public void bad() throws Exception
	{
		File f = new File("C:\\data.txt");
		
		BufferedReader buffread = null;
		FileInputStream fis = null;
		InputStreamReader instrread = null;
		
		String data;
		String root = "C:\\";
		
		try{			
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
			File f1 = new File(data + "102-1.txt");
			File f2 = new File("C:\\102-2.txt");
			
			f1.renameTo(f2);
			
			File f3 = new File(data);
			File f4 = new File("C:\\102-2.txt");
			
			f3.renameTo(f4);
			
			File f5 = new File(root + data);
			File f6 = new File("C:\\102-2.txt");
			
			f5.renameTo(f6);
		}
	}
}
