package sample.cwe652;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.*;

public class Console_executeQuery {
	
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		String data = "";
		
		try{			
			instrread = new InputStreamReader(System.in, "UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();				
		}
		
		XQDataSource ds = new SaxonXQDataSource();
		XQConnection xqconn = ds.getConnection();	
		
		//tcp data
		XQPreparedExpression exp = xqconn.prepareExpression(data);
		
		//POTENTIAL FLAW
		XQResultSet result = exp.executeQuery();
		
		while(result.next())
		{
			System.out.println(result.getItemAsString());
		}
	}
    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		String data = "select * from helo";		
		
		XQDataSource ds = new SaxonXQDataSource();
		XQConnection xqconn = ds.getConnection();	
		
		//tcp data
		XQPreparedExpression exp = xqconn.prepareExpression(data);
		
		//POTENTIAL FLAW
		XQResultSet result = exp.executeQuery();
		
		while(result.next())
		{
			System.out.println(result.getItemAsString());
		}
	}
}
