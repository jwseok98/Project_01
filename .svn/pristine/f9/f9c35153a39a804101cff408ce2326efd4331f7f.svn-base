/*
Filename : KRD_302_Uncontrolled_Recursion__fromDB_2_recursion_0101_bad.java
CWEID    : CWE674
sinkname : recursion
sinkline : 47,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe674.kisa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import sample.IO;

public class KRD_302_Uncontrolled_Recursion__fromDB_2_recursion_0101_bad 
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

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* setup the connection */
            conn = IO.getDBConnection();

            /* prepare and execute a (hardcoded) query */
            statement = conn.prepareStatement("select name from users where id=1");
            rs = statement.executeQuery();
            rs.next();
            
            data = rs.getString(1);
        }
        catch( SQLException se )
        {
            IO.logger.log(Level.WARNING, "Error with SQL statement", se);
        }
        finally {
                /* Close database objects */
                try {
                    if( rs != null )
                    {
                        rs.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing ResultSet", se);
                }

                try {
                    if( statement != null )
                    {
                        statement.close();
                    }
                }
                catch( SQLException se )
                {
                    IO.logger.log(Level.WARNING, "Error closing Statement", se);
                }

                try {
                    if( conn != null )
                    {
                        conn.close();
                    }
                }
                catch( SQLException se)
                {
                    IO.logger.log(Level.WARNING, "Error closing Connection", se);
                }
            }
        
        System.out.println(recursion_bad(Integer.parseInt(data)));


    }


    
  
}

