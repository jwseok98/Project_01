/*
Filename : KRD_206_Cleartext_Transmission_of_Sensitive_Information__console_readLine_2_getConnection_0101_bad.java
CWEID    : CWE256
sinkname : getConnection
sinkline : 119,
makedate : 2014 02 10
license  : Copyright KISA.
*/

package sample.cwe312.kisa;



import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.util.logging.Level;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Logger;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.File;
import java.util.logging.Level;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;


import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Logger;

public class KRD_206_Cleartext_Transmission_of_Sensitive_Information__console_readLine_2_getConnection_0101_bad 
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* read user input from console with readLine*/
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            instrread = new InputStreamReader(System.in);
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
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }
        }


		java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        /* POTENTIAL FLAW: direct retrieval of plaintext password */
        Connection conn2 = null;
        try
        {
            conn2 = DriverManager.getConnection("192.168.105.23", "sa", data);
        }
        catch(SQLException se)
        {
            log2.warning("error getting database connection");
        }
        finally
        {
            try
            {
                if( conn2 != null )
                {
                    conn2.close();
                }
            }
            catch( SQLException se )
            {
                log2.warning("error closing conn2");
            }
        }


    }


   
}

