package sample.cwe134;

public class KRD_115_Uncontrolled_Format_String__Environment_printf_0101_bad{
	
	public void bad() throws Exception
	{
		
		String data = "";
				
		{
			data = System.getenv("ADD");
		}

		if(data != null)
		{
			System.out.printf(data);	
		}		
	}
}
