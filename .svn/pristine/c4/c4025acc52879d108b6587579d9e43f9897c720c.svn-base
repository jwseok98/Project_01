/*
Filename : KRD_402_Error_Without_Action__Environment_2_mkdirs_0101_bad.java
CWEID    : CWE390
sinkname : mkdirs
sinkline : 58,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe390;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.lang.SecurityException;


import javax.servlet.http.*;

import java.util.logging.Logger;

public class KRD_402_Error_Without_Action__Environment_2_mkdirs_0101_bad 
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        FileInputStream fis = null;
        File dirs = null;
        if(data != null)
        { 
        	dirs= new File(data);
        }
        
        try
        {
        	fis = new FileInputStream(dirs);
        }
		catch(FileNotFoundException e)
        {
        	/* FLAW: do nothing if dirs cannot be created */
        }
        finally
        {
        	try
        	{
        		if(fis != null)
        		{
        			fis.close();
        		}
        	}
        	catch(IOException e)
        	{
        		IO.logger.log(Level.WARNING, "Error closing FileInputStream", e);
        	}
        }


    }


    
  
}

