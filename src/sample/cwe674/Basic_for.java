package sample.cwe674;

public class Basic_for {
	public void bad()
	{
		
		for (int i = 0; i >= 0; i = (i+1) % 256) {
			IO.writeLine(i);
		}
	}
}
