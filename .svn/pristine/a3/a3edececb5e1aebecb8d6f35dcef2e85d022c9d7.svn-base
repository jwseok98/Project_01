/*
Filename : KRD_109_LDAP_Injection__fromFile_search_0101_bad.java
CWEID    : CWE90_LDAP_Injection
sinkname : search
sinkline : 114,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe90;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class KRD_109_LDAP_Injection__fromFile_search_0101_bad
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

