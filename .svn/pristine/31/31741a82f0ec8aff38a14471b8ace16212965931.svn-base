/*
Filename : KRD_402_Error_Without_Action__connect_tcp_2_mkdirs_0101_bad.java
CWEID    : CWE390
sinkname : mkdirs
sinkline : 115
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

import java.util.logging.Logger;

import java.io.File;
import java.lang.SecurityException;


import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;

import java.util.logging.Logger;

public class KRD_402_Error_Without_Action__connect_tcp_2_mkdirs_0101_bad 
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* Read data using an outbound tcp connection */
            sock = new Socket("192.168.0.100", 9000);

            /* read input from socket */
            instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
            buffread = new BufferedReader(instrread);

            data = buffread.readLine();
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
        	/* clean up stream reading objects */
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
        		if( instrread != null )
        		{
        			instrread.close();
        		}
        	}
        	catch( IOException ioe )
        	{
        		IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
        	}

        	/* clean up socket objects */
        	try {
        		if( sock != null )
        		{
        			sock.close();
        		}
        	}
        	catch( IOException e )
        	{
        		IO.logger.log(Level.WARNING, "Error closing Socket", e);
        	}
        }
        FileInputStream fis = null;
        File dirs = null;
        if(data != null)
        { 
        	dirs= new File(data);
        }
        
        try
        {
        	fis = new FileInputStream(dirs);
        } catch(FileNotFoundException e)
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

