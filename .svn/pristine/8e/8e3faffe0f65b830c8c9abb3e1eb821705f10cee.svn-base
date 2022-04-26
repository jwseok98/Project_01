package sample.cwe330;

import java.util.Random;
import java.util.logging.Logger;

import sample.cwe539.IO;

public class Environment_2_Random {
	
	public void bad(){
		
		String data; 
		
		Logger log_bad = Logger.getLogger("local-logger");
		
		data = System.getenv("ADD");
		
		Random rand = new Random();
		
		rand.setSeed(Integer.valueOf(data));
		IO.writeLine("Random int: "+rand.nextInt(100));
		
	}
}
