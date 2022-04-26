package sample.cwe259;

import javax.security.auth.kerberos.KerberosPrincipal;
import javax.security.auth.kerberos.KerberosKey;

public class KRD_207_KerberosKey_0101_bad {
    public void bad() throws Throwable
    {
        String data;

        /* FLAW: Set data to a hardcoded string */
        data = "7e5tc4s3";
        
        if (data != null)
        {
            KerberosPrincipal principal = new KerberosPrincipal(data);
            
            /* POTENTIAL FLAW: data used as password in KerberosKey() */
			KerberosKey key = new KerberosKey(principal, data.toCharArray(), null);

            sample.cwe.logger.Logger.writeLine(key.toString());
        }        
    }
}
