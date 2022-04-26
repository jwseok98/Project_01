package sample.cwe23_36_99;

import java.io.*;

public class Environment_AbsolutePathTraversal {
	
	public void bad() throws Exception
	{
		String data = System.getenv("ADD");
		
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
