package sample.cwe652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listen_tcp_executeQuery {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String data = "";
    	ServerSocket listener = null;
    	Socket sock = null;
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
    	try{
    		listener = new ServerSocket(9000);
    		sock = listener.accept();
    		
			instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		if(buffread != null)
    		{
    			buffread.close();
    		}
    		if(instrread != null)
    		{
    			instrread.close();
    		}
    		if(sock != null)
    		{
    			sock.close();
    		}
    		if(listener != null)
    		{
    			listener.close();
    		}
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
