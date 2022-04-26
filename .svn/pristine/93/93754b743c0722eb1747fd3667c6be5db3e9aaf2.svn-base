/*
Filename : KRD_501_NULL_Pointer_Dereference__Servlet_data_is_not_null_0101_good.java
CWEID    : CWE476
sinkname : data_is_not_null
sinkline : 44,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe476;



import javax.servlet.http.*;
import java.io.*;


import javax.servlet.http.*;
import java.io.*;

public class KRD_501_NULL_Pointer_Dereference__Servlet_data_is_not_null_0101_good 
{


    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        goodB2G(request, response);
    }

    
    
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;


        /* POTENTIAL FLAW: string is null */
        data = null;



        /* FIX: validate that data is non-null */
        if( data != null )
        {
            response.getWriter().println("" + data.length());
        }
        else
        {
            response.getWriter().println("data is null");
        }


    }

   
}

