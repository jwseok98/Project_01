/*
Filename : KRD_302_Uncontrolled_Recursion__fromFile_2_recursion_0101_bad.java
CWEID    : CWE674
sinkname : recursion
sinkline : 45,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe674.kisa;

import sample.IO;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.File;
import java.util.logging.Level;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class KRD_302_Uncontrolled_Recursion__fromFile_2_recursion_0101_bad 
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

    public void bad() throws Throwable

    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        File f = new File("C:\\data.txt");
        BufferedReader buffread = null;
        FileInputStream fis = null;
        InputStreamReader isread = null;
        try {
            /* read string from file into data */
            fis = new FileInputStream(f);
            isread = new InputStreamReader(fis, "UTF-8");
            buffread = new BufferedReader(isread);

            data = buffread.readLine(); // This will be reading the first "line" of the file, which
            // could be very long if there are little or no newlines in the file\
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }
        finally
        {
        /* Close stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            } 
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
            }
            try {
                if( isread != null )
                {
                    isread.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
            }
             try {
                if( fis != null )
                {
                    fis.close();
                }
            }
            catch( IOException ioe )
            {
                IO.logger.log(Level.WARNING, "Error closing FileInputStream", ioe);
            }
        }

        System.out.println(recursion_bad(Integer.parseInt(data)));


    }


    
  
}

