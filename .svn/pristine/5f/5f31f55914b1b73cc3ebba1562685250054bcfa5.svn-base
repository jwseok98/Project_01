package sample.cwe312;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.security.auth.kerberos.KerberosKey;
import javax.security.auth.kerberos.KerberosPrincipal;

public class URLConnection_KerberosKey {
	
	public void bad() throws Exception{
		
		String data = "";
		
		URLConnection conn = (new URL("http://192.168.0.100/taint.html/")).openConnection();
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		
		
		try {
					
			instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String [] datas = data.split("/");
		String password = datas[0];
		
		if (password != null) {
			KerberosPrincipal principal = new KerberosPrincipal("test");
			
			KerberosKey key = new KerberosKey(principal, password.toCharArray(), null);
			IO.writeLine(key.toString());
		}
		
	}
	
}
