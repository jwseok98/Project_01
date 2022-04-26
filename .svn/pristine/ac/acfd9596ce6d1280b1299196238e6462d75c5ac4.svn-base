package sample.cwe23_36_99;

import java.io.*;

public class Environment_RelativePathTraversal {
	
	public void bad() throws Exception
	{
		String data = System.getenv("ADD");
		String root = "/usr/local/evenstar";		
		
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
