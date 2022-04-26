package sample.cwe330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import sample.cwe539.IO;

public class Console_readLine_2_Random {
	
	public void bad(){
		
		String data;
		data = "";
		
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		try {
			
			instrread = new InputStreamReader(System.in, "UTF-8");
			buffread = new BufferedReader(instrread);
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Random rand = new Random();
		
		rand.setSeed(Integer.valueOf(data));
		IO.writeLine("Random int : "+rand.nextInt(100));
		
	}
	
}
