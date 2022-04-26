package sample.cwe674;

public class Basic_do_true {
	
	public void bad()
	{		
		int i = 0;
		
		do {
			IO.writeLine(i);
			i++;
		} while (true);
	}
	public void good()
	{
		int i = 0;
		
		do {
			IO.writeLine(i);
			i++;
		} while (i<100);
	}
}
