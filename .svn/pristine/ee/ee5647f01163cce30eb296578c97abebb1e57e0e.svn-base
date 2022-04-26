package sample.cwe495;

public class KRD_604_Private_Array_Typed_Field_Returned_From_A_Public_Method__basic_return_0101_good {
	private byte[] foo = null;
	
    public byte[] getFoo()
    {
        byte[] tmp_array = null;
    	if(foo != null)
    	{
    		tmp_array = new byte[foo.length];
    		for(int i=0;i<foo.length;i++)
    		{
    			tmp_array[i] = foo[i];
    		}
    	}
        return tmp_array;
    }

    public void good() throws Throwable
    {

        goodB2G();
    }

    
    
    private void goodB2G() throws Throwable
    {
        /* FIX */
        byte[] tmp_data = getFoo();


    }

}
