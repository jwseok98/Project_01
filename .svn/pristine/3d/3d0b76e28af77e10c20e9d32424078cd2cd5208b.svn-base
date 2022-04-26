package sample.cwe330;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;

import sample.cwe539.IO;

public class FromFile_2_Random {
	
	public void bad(){
		
		File f = new File("C:\\data.txt");
		BufferedReader buffread = null;
		FileInputStream fis = null;
		InputStreamReader isread = null;
		
		String data = "";
		
		try {
		
			fis = new FileInputStream(f);
			isread = new InputStreamReader(fis, "UTF -8");
			buffread = new BufferedReader(isread);
			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		Random rand = new Random();
		
		rand.setSeed(Integer.valueOf(data));
		IO.writeLine("RAndom int: " + rand.nextInt(100));
	}
}