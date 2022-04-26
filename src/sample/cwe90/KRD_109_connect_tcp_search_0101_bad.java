package sample.cwe90;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.*;

import javax.naming.*;
import javax.naming.directory.*;

public class KRD_109_connect_tcp_search_0101_bad {
	
	public void bad() throws Exception
	{
		String data = "";
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		
		try{
			sock = new Socket("192.168.0.100", 9000);			
			instrread = new InputStreamReader(sock.getInputStream(),"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();				
			if(sock != null) sock.close();
		}
		
        Hashtable<String, String> environmentHashTable = new Hashtable<String, String>();
        environmentHashTable.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        environmentHashTable.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext ctx = null;

        try
        {
        	ctx = new InitialDirContext(environmentHashTable);
            /* POTENTIAL FLAW: data concatenated into LDAP search, which could result in LDAP Injection */
            String search = "(cn=" + data + ")";

            NamingEnumeration<SearchResult> answer = ctx.search("CN=Schema,CN=Configration,DC=adtest,DC=com", search, null);
            while (answer.hasMore())
            {
                SearchResult searchResult = answer.next();
                Attributes attributes = searchResult.getAttributes();
                NamingEnumeration<?> allAttributes = attributes.getAll();
                while (allAttributes.hasMore())
                {
                    Attribute attribute = (Attribute) allAttributes.next();
                    NamingEnumeration<?> allValues = attribute.getAll();
                    while(allValues.hasMore())
                    {
                        sample.cwe.logger.Logger.writeLine(allValues.next().toString());
                    }
                }
            }
        }
        catch (NamingException exceptNaming)
        {
        	sample.cwe.logger.Logger.writeLine("The LDAP service was not found or login failed." +  exceptNaming);
        }
        finally
        {
            if (ctx != null)
            {
                try
                {
                    ctx.close();
                }
                catch (NamingException exceptNaming)
                {
                	sample.cwe.logger.Logger.writeLine("Error closing DirContext" + exceptNaming);
                }
            }
        }
	}
	public void bad2() throws Exception
	{
		String data = "";
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		
		try{
			sock = new Socket("192.168.0.100", 9000);			
			instrread = new InputStreamReader(sock.getInputStream(),"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();				
			if(sock != null) sock.close();
		}
		
        Hashtable<String, String> environmentHashTable = new Hashtable<String, String>();
        environmentHashTable.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        environmentHashTable.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext ctx = null;

        try
        {
        	ctx = new InitialDirContext(environmentHashTable);
            /* POTENTIAL FLAW: data concatenated into LDAP search, which could result in LDAP Injection */
        	StringBuffer bf = new StringBuffer();
        	bf.append("(cn=");
        	bf.append(data);
        	bf.append(")");
        	
            String search = bf.toString();

            NamingEnumeration<SearchResult> answer = ctx.search("CN=Schema,CN=Configration,DC=adtest,DC=com", search, null);
            while (answer.hasMore())
            {
                SearchResult searchResult = answer.next();
                Attributes attributes = searchResult.getAttributes();
                NamingEnumeration<?> allAttributes = attributes.getAll();
                while (allAttributes.hasMore())
                {
                    Attribute attribute = (Attribute) allAttributes.next();
                    NamingEnumeration<?> allValues = attribute.getAll();
                    while(allValues.hasMore())
                    {
                        sample.cwe.logger.Logger.writeLine(allValues.next().toString());
                    }
                }
            }
        }
        catch (NamingException exceptNaming)
        {
        	sample.cwe.logger.Logger.writeLine("The LDAP service was not found or login failed." +  exceptNaming);
        }
        finally
        {
            if (ctx != null)
            {
                try
                {
                    ctx.close();
                }
                catch (NamingException exceptNaming)
                {
                	sample.cwe.logger.Logger.writeLine("Error closing DirContext" + exceptNaming);
                }
            }
        }
	}

	public void bad3() throws Exception
	{
		String data = "";
		
		Socket sock = null;
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		
		try{
			sock = new Socket("192.168.0.100", 9000);			
			instrread = new InputStreamReader(sock.getInputStream(),"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();				
			if(sock != null) sock.close();
		}
		
        Hashtable<String, String> environmentHashTable = new Hashtable<String, String>();
        environmentHashTable.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        environmentHashTable.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext ctx = null;

        try
        {
        	ctx = new InitialDirContext(environmentHashTable);
            /* POTENTIAL FLAW: data concatenated into LDAP search, which could result in LDAP Injection */
        	StringBuilder bf = new StringBuilder();
        	bf.append("(cn=");
        	bf.append(data);
        	bf.append(")");
        	
            String search = bf.toString();

            NamingEnumeration<SearchResult> answer = ctx.search("CN=Schema,CN=Configration,DC=adtest,DC=com", search, null);
            while (answer.hasMore())
            {
                SearchResult searchResult = answer.next();
                Attributes attributes = searchResult.getAttributes();
                NamingEnumeration<?> allAttributes = attributes.getAll();
                while (allAttributes.hasMore())
                {
                    Attribute attribute = (Attribute) allAttributes.next();
                    NamingEnumeration<?> allValues = attribute.getAll();
                    while(allValues.hasMore())
                    {
                        sample.cwe.logger.Logger.writeLine(allValues.next().toString());
                    }
                }
            }
        }
        catch (NamingException exceptNaming)
        {
        	sample.cwe.logger.Logger.writeLine("The LDAP service was not found or login failed." +  exceptNaming);
        }
        finally
        {
            if (ctx != null)
            {
                try
                {
                    ctx.close();
                }
                catch (NamingException exceptNaming)
                {
                	sample.cwe.logger.Logger.writeLine("Error closing DirContext" + exceptNaming);
                }
            }
        }
	}
}
