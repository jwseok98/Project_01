/*
Filename : KRD_501_NULL_Pointer_Dereference__StringBuilder_data_is_not_null_0101_good.java
CWEID    : CWE476_NULL_Pointer_Dereference
sinkname : data_is_not_null
sinkline : 34,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe476;



public class KRD_501_NULL_Pointer_Dereference__StringBuilder_data_is_not_null_0101_good 
{


    public void good() throws Throwable
    {

        goodB2G();
    }

    
    
    private void goodB2G() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: string is null */
        data = null;

        /* FIX: validate that data is non-null */
        if( data != null )
        {
            System.out.println("" + data.length());
        }
        else
        {
            System.out.println("data is null");
        }

    }

   
}

