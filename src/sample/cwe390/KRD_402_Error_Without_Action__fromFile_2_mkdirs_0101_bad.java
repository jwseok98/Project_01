/*
Filename : KRD_402_Error_Without_Action__fromFile_2_mkdirs_0101_bad.java
CWEID    : CWE390
sinkname : mkdirs
sinkline : 126,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe390;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.logging.Level;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

import java.io.File;
import java.util.logging.Level;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.lang.SecurityException;


import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.File;
import java.util.logging.Level;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

public class KRD_402_Error_Without_Action__fromFile_2_mkdirs_0101_bad 
{

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

        FileInputStream fis2 = null;
        File dirs = null;
        if(data != null)
        { 
        	dirs= new File(data);
        }
        
        try
        {
        	fis2 = new FileInputStream(dirs);
        }
		catch(FileNotFoundException e)
        {
        	/* FLAW: do nothing if dirs cannot be created */
        }
        finally
        {
        	try
        	{
        		if(fis2 != null)
        		{
        			fis2.close();
        		}
        	}
        	catch(IOException e)
        	{
        		IO.logger.log(Level.WARNING, "Error closing FileInputStream", e);
        	}
        }


    }


    
   
}

