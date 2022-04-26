/*
Filename : KRD_110_Cross_Site_Request_Forgery__getParameterServlet_write_0101_good.java
CWEID    : CWE352_Cross_Site_Request_Forgery
sinkname : write
sinkline : 56,
makedate : 2012 12 24
license  : Copyright KISA.
*/

package sample.cwe352;



import javax.servlet.http.*;

import java.util.logging.Logger;

public class KRD_110_Cross_Site_Request_Forgery__getParameterServlet_write_0101_good 
{


    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        goodB2G(request, response);
    }

    
    
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from request */
        data = request.getParameter("name");

        /* Assuming the presence of a session variable called "token" that contains
             * the nonce value to prevent CSRF */
        /* This testcase is dependent on several others to be a valid weakness:
         *	346 - Origin Validation Error
         *	441 - Unintended Proxy/Intermediary
         *	613 - Insufficient Session Expiration */

        HttpSession session = request.getSession(true);
        String trustedToken = session.getAttribute("token").toString();

        /* FIX: test the value of the request's "token" vs. the session "token" */
        if( request.getParameter("token") == null ||
        !request.getParameter("token").equals(trustedToken) )
        {
            return;
        }

        response.getWriter().write(data);

    }

   
}

