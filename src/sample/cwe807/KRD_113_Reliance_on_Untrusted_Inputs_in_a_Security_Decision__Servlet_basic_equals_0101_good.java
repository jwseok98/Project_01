/*
Filename : KRD_114_Reliance_on_Untrusted_Inputs_in_a_Security_Decision__Servlet_basic_equals_0101_good.java
CWEID    : CWE807
sinkname : equals
sinkline : 127,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe807;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.IO;
import sample.cwe285.KrdUtil;

public class KRD_113_Reliance_on_Untrusted_Inputs_in_a_Security_Decision__Servlet_basic_equals_0101_good
{

    

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - uses goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String data = "";
    	
    	boolean authenticated = false;
    	
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username == null || password == null || !KrdUtil.isAuthenticatedUser(username, password))
        {
        	throw new Exception("Authentication Error occurred");
        }
        
        Logger log2 = Logger.getLogger("local-logger");

        Connection conn_tmp2 = null;
        PreparedStatement sqlstatement = null;
        ResultSet sqlrs = null;

        try {
            /* FIX: use prepared sqlstatement */
            conn_tmp2 = IO.getDBConnection();
            sqlstatement = conn_tmp2.prepareStatement("select role from users where name=?");
            sqlstatement.setString(1, username);

            sqlrs = sqlstatement.executeQuery();

            sqlrs.next();
            data = sqlrs.getString(1);
        }
        catch( SQLException se )
        {
            log2.warning("Error getting database connection");
        }
        finally {
            try {
                if( sqlrs != null )
                {
                    sqlrs.close();
                }
            }
            catch( SQLException e )
            {
                log2.warning("Error closing sqlrs");
            }
            finally {
                try {
                    if( sqlstatement != null )
                    {
                        sqlstatement.close();
                    }
                }
                catch( SQLException e )
                {
                    log2.warning("Error closing sqlstatement");
                }
                finally {
                    try {
                        if( conn_tmp2 != null )
                        {
                            conn_tmp2.close();
                        }
                    }
                    catch( SQLException e )
                    {
                        log2.warning("Error closing conn_tmp2");
                    }
                }
            }
        }

        Cookie[] cookies = request.getCookies();
        for (int i =0; i< cookies.length; i++) {
            Cookie c = cookies[i];
            
            if (c.getName().equals("role")) 
            {
            	/* FIX */
            	if(data.equals(c.getValue()))
            	{
            		authenticated = true;
            	}
            	else
            	{
            		c = new Cookie("authenticated", "");
            	}
            }
        }


    }

  
}

