/*
Filename : KRD_109_LDAP_Injection__getQueryStringServlet_search_0101_bad.java
CWEID    : CWE90_LDAP_Injection
sinkname : search
sinkline : 68,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe90;



import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.IO;

public class KRD_109_LDAP_Injection__getQueryStringServlet_search_0101_bad 
{

    
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");
        data = "";

        
        {
            StringTokenizer st = new StringTokenizer(request.getQueryString(), "&");
            while (st.hasMoreTokens())
            {
                String token = st.nextToken(); /* a token will be like "id=foo" */
                if(token.startsWith("id="))   /* check if we have the "id" parameter" */
                {
                    data = token.substring(3); /* set data to "foo" */
                    break; /* exit while loop */
                }
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

