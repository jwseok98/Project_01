/*
 * 참조: 없음. 스프링 MVC 기반 샘플 - LDAP 삽입
 */
package sample.cwe90.spring;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CWE90_ldapi_spring_basic_bad01 {
	
	@ResponseBody
	@RequestMapping(value="/searchRecord")
	public String searchRecord(String userSN, String userPassword) throws NamingException {
		
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		
		try {
			DirContext dctx = new InitialDirContext(env);
			SearchControls sc = new SearchControls();
			String[] attributeFilter = { "cn", "mail" };
			sc.setReturningAttributes(attributeFilter);
			
			sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String base = "dc=example,dc=com";
			String filter = "(&(sn=" + userSN + ")(userPassword=" + userPassword + "))";
			
			// POTENTAIL FLAW
			NamingEnumeration<?> results = dctx.search(base, filter, sc);
			while (results.hasMore()) {
				SearchResult sr = (SearchResult) results.next();
				Attributes attrs = sr.getAttributes();
				Attribute attr = attrs.get("cn");
				return attr.toString();
			}
			dctx.close();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return "no record";
	}
		
		

}
