package sample.cwe259;

import java.net.PasswordAuthentication;

public class KRD_207_PasswordAuthentication_0101_bad {
    public void bad() throws Throwable
    {
        String data;

        /* FLAW: Set data to a hardcoded string */
        data = "7e5tc4s3";
        
        if (data != null)
        {
            /* POTENTIAL FLAW: data used as password in PasswordAuthentication() */
            PasswordAuthentication pa = new PasswordAuthentication("user", data.toCharArray());
            sample.cwe.logger.Logger.writeLine(pa.toString());
        }
    }
}
