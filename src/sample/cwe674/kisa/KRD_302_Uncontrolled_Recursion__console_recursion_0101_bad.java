/*
Filename : KRD_302_Uncontrolled_Recursion__console_recursion_0101_bad.java
CWEID    : CWE674
sinkname : recursion
sinkline : 28,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe674.kisa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

import sample.IO;

public class KRD_302_Uncontrolled_Recursion__console_recursion_0101_bad 
{

	private static long recursion_bad(long n)
	{
    	if (n < Long.MAX_VALUE)
    	{
    		/* FLAW: Missing base case */
    		long ret = n + recursion_bad(n-1);
    		return ret;
    	}
    	else
    	{
    		IO.writeLine("Input value is too large to perform.");
    		return 0;
    	}
	}
	
	public void bad() throws IOException 
    {
        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;
		int num = 0;
        try
        {
            inread2 = new InputStreamReader(System.in, "UTF-8");
            bufread2 = new BufferedReader(inread2);

            System.out.print("Enter num:");
            
            try
            {
                num = Integer.parseInt(bufread2.readLine());
            }
            catch(IOException ioe)
            {
				IO.logger.log(Level.WARNING, "Error reading from console", ioe);
            }
			catch(NumberFormatException nfe)
			{
				IO.logger.log(Level.WARNING, "Error converting to int", nfe);
			}
			finally
			{
				/* default num of 1 */
                num = 1;
			}
        }
        catch( IOException e )
        {
            log2.warning("Error!");
        }
        finally 
        {
            try 
            {
                if( bufread2 != null ) 
                {
                    bufread2.close();
                }
            }
            catch( IOException e )
            {
                log2.warning("Error closing bufread2");
            }
            finally 
            {
                try 
                {
                    if( inread2 != null ) 
                    {   
                        inread2.close();
                    }
                }
                catch( IOException e )
                {
                    log2.warning("Error closing inread2");
                }
            }
        }
            
        System.out.println(recursion_bad(num));
	}
	
		
}
