package sample.cwe23_36_99;

import java.io.*;

public class KRD_102_Environment_File_0101_bad {
	
	public void bad() throws Exception
	{
		String data = System.getenv("ADD");
		String root = "D:/evenstar/ok";
		
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
