/*
Filename : KRD_302_Uncontrolled_Recursion__Environment_2_recursion_0101_bad.java
CWEID    : CWE674
sinkname : recursion
sinkline : 37,
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

import java.util.logging.Logger;

public class KRD_302_Uncontrolled_Recursion__Environment_2_recursion_0101_bad 
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

        /* get environment variable ADD */
        data = System.getenv("TEST302");

        System.out.println(recursion_bad(Integer.parseInt(data)));


    }


    
  
}

