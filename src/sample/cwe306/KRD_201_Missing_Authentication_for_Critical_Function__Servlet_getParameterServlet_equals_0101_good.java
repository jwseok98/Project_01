/*
Filename : KRD_201_Missing_Authentication_for_Critical_Function__Servlet_getParameterServlet_equals_0101_good.java
CWEID    : CWE306
sinkname : isAuthenticatedUser, equals
sinkline : 93,
makedate : 2012 08 27
license  : Copyright KISA.
*/

package sample.cwe306;



import javax.servlet.http.*;
import java.io.*;
import java.net.*;
import java.util.logging.Logger;


import javax.servlet.http.*;
import java.io.*;

public class KRD_201_Missing_Authentication_for_Critical_Function__Servlet_getParameterServlet_equals_0101_good 
{
	class BankAccount
	{
		int accountNumber;
		String toPerson;
		int balance;

		public void setAccountNumber(int accountNumber)
		{
			this.accountNumber= accountNumber;
		}
		public void setToPerson(String toPerson)
		{
			this.toPerson = toPerson;
		}
		public void setBalance(int balance)
		{
			this.balance = balance;
		}
		public int send()
		{
			return 0;
		}		
	}

 

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }
	
	public boolean isAuthenticatedUser()
	{
		return true;
	}

    /* goodG2B() - uses goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String newUserName;
        String newPassword;
        String password;
        String userName;
		String toPerson;
		int balance, accountNumber;

        newUserName = request.getParameter("username");
        newPassword = request.getParameter("password");
        toPerson ="person";
		balance = 1;
		accountNumber = 11;
		
        if(newUserName == null || newPassword == null)
        {
            response.getWriter().println("first data error");
        }
        
		HttpSession session = request.getSession(true);
		
        password = session.getAttribute("password").toString();
	    userName = session.getAttribute("username").toString();
        
        if(password == null || userName == null)
        {
            response.getWriter().println("second data error");
        }
        
        /* FIX */
      	if (isAuthenticatedUser() && newUserName.equals(userName) && newPassword.equals(password))
      	{
			BankAccount account = new BankAccount();
      		account.setAccountNumber(accountNumber);
      		account.setToPerson(toPerson);
      		account.setBalance(balance);
      		account.send();
        }
	}
}

