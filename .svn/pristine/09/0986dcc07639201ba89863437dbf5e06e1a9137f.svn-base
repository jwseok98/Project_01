/*
Filename : KRD_109_LDAP_Injection__fromDB_search_0101_bad.java
CWEID    : CWE90_LDAP_Injection
sinkname : search
sinkline : 116,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe90;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import sample.IO;

public class KRD_109_LDAP_Injection__fromDB_search_0101_bad 
{

    
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

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://192.168.0.100:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "ADTEST\\Administrator");
        env.put(Context.SECURITY_CREDENTIALS, "kisa123#");
        env.put(Context.REFERRAL, "follow");
        LdapContext ctx = new InitialLdapContext(env, null);

        String search = "(cn=" + data + ")"; 
        /* POTENTIAL FLAW: unsanitized data from untrusted source */
        NamingEnumeration<SearchResult> answer = ctx.search("CN=Schema,CN=Configuration,DC=adtest,DC=com", search, null);
        while (answer.hasMore())
        {
            SearchResult sr = answer.next();
            Attributes a = sr.getAttributes();
            NamingEnumeration<?> attrs = a.getAll();
            while (attrs.hasMore())
            {
                Attribute attr = (Attribute) attrs.next();
                NamingEnumeration<?> values = attr.getAll();
                while(values.hasMore())
                {
                    IO.writeLine(" Value: " + values.next().toString());
                }
            }
        }

    }


 
}

