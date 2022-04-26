/*
Filename : KRD_402_Error_Without_Action__reader_FileNotFoundException_0101_bad.java
CWEID    : CWE390_Error_Without_Action
sinkname : FileNotFoundException
sinkline : 38,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe390;



import javax.servlet.http.*;

import java.io.*;
import java.util.logging.Level;

public class KRD_402_Error_Without_Action__reader_FileNotFoundException_0101_bad 
{

    public void bad() throws Throwable
    {

        File f = new File("C:\\doesntexistandneverwill.txt");
        FileInputStream fis = null;
        InputStreamReader isread = null;
        BufferedReader reader = null;

        try
        {
            fis = new FileInputStream(f);
            isread = new InputStreamReader(fis, "UTF-8");
            reader = new BufferedReader(isread);
        }
        catch( FileNotFoundException fe )
        {
            /* FLAW: do nothing if the file doesn't exist */
        }
        finally
        {
            /* Close stream reading objects */
            try {
                if( reader != null )
                {
                    reader.close();
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

    }


}

