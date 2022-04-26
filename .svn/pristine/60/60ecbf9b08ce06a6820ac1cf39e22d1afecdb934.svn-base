package sample.cwe674;

public class KRD_302_Uncontrolled_Recursion__basic_do_0101_bad {

	public void bad()
	{
		
		int i = 0;
		
		do {
			IO.writeLine(i);
			i= (i+1) %256;
		} while (i >=0);
	}
	public void good()
	{
		
		int i = 0;
		
		do {
			IO.writeLine(i);
			i= (i+1) %256;
			
			if(i == 1)
			{
				break;
			}
			
		} while (i >=0);
	}
}
