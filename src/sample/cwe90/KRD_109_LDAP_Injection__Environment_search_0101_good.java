/*
Filename : KRD_109_LDAP_Injection__Environment_search_0101_bad.java
CWEID    : CWE90_LDAP_Injection
sinkname : search
sinkline : 51,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe90;



import java.util.Hashtable;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import sample.IO;

public class KRD_109_LDAP_Injection__Environment_search_0101_good 
{

    
    public void good() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("TEST109");

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://192.168.0.100:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "ADTEST\\Administrator");
        env.put(Context.SECURITY_CREDENTIALS, "kisa123#");
        env.put(Context.REFERRAL, "follow");
        LdapContext ctx = new InitialLdapContext(env, null);

        String search = "(cn=" + data.replaceAll("\\*", "") + ")";
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
