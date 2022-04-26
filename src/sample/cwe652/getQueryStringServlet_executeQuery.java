package sample.cwe652;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getQueryStringServlet_executeQuery {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String data = "";
    	
    	{
    		StringTokenizer st = new StringTokenizer(request.getQueryString(),"&");
    		
    		while(st.hasMoreTokens())
    		{
    			String token = st.nextToken();
    			if(token.startsWith("id="))
    			{
    				data = token.substring(3);
    				break;
    			}
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
