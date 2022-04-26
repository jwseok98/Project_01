package sample.cwe652;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.*;

public class URLConnection_executeQuery {
	
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String data = "";
    	
    	URLConnection conn = (new URL("http://192.168.1.1/index.html")).openConnection();
    	
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		try{			
			instrread = new InputStreamReader(conn.getInputStream(), "UTF-8");
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
}
