package sample.cwe306;

import javax.servlet.http.*;

public class KRD_201_Servlet_getParameterServlet_equals_0101_bad {

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String password = request.getParameter("password");
    	String userName = request.getParameter("userName");
    	
    	String accountNumber = request.getParameter("accountNumber");
    	String toPerson = request.getParameter("toPerson");
    	String balance = request.getParameter("balance");
    
    	if(password == null || userName == null)
    	{
    		response.getWriter().println("second data error");
    	}
    	
    	//potential flaw    	
    	BankAccount account = new BankAccount();
    	account.setAccountNumber(accountNumber);
    	
    	System.out.println("asd");
    	account.setToPerson(toPerson);
    	account.setBalance(balance);
    	account.send();
    }
    
    public void bad2(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String password = request.getParameter("password");
    	String userName = request.getParameter("userName");
    	
    	String accountNumber = request.getParameter("accountNumber");
    	String toPerson = request.getParameter("toPerson");
    	String balance = request.getParameter("balance");
    	    	
    	if(password == null || userName == null)
    	{
    		response.getWriter().println("second data error");
    	}
    	
    	//potential flaw    	
    	BankAccount account = new BankAccount();
    	account.setAccountNumber(accountNumber);
    	account.setToPerson(toPerson);
    	account.setBalance(balance);
    	AccountManager.send(account);
    }
    
    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String password = request.getParameter("password");
    	String userName = request.getParameter("userName");
    	
    	String accountNumber = request.getParameter("accountNumber");
    	String toPerson = request.getParameter("toPerson");
    	String balance = request.getParameter("balance");
    	
    	if(password == null || userName == null)
    	{
    		response.getWriter().println("second data error");
    	}
    	
    	HttpSession session = request.getSession();
    	String sessPassword = (String)session.getValue("password");
    	String sessUserName = (String)session.getValue("userName");
    	
    	if(isAuthenticateduser() && password.equals(sessPassword) && userName.equals(sessUserName))
    	{
        	BankAccount account = new BankAccount();
        	account.setAccountNumber(accountNumber);
        	account.setToPerson(toPerson);
        	account.setToPerson(balance);
        	account.send();
    	}
    }
    public boolean isAuthenticateduser()
    {
    	return false;
    }
}
