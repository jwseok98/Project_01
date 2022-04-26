package sample.cwe330;

import java.util.*;

import sample.cwe539.IO;

public class KRD_209_basic_Random_0101_bad {
	
	public void bad(){
		
		Random rand = new Random();
		
		rand.setSeed(123456);
		IO.writeLine("Random int: "+rand.nextInt(100));
		
	}
	public void good1()
	{
		Random rand = new Random();
		
		rand.setSeed(System.currentTimeMillis());
		IO.writeLine("Random int: "+rand.nextInt(100));
	}
	public void good2()
	{
		Random rand = new Random();
		
		rand.setSeed(new Date().getTime());
		IO.writeLine("Random int: "+rand.nextInt(100));
	}
	public void good3()
	{
		Random rand = new Random();
		Date d = new Date();
		long l = d.getTime();
		rand.setSeed(l);
		IO.writeLine("Random int: "+rand.nextInt(100));
	}
	public void good4()
	{
		Random rand = new Random();
		long l = System.currentTimeMillis();
		
		rand.setSeed(l);
		IO.writeLine("Random int: "+rand.nextInt(100));
	}
}
