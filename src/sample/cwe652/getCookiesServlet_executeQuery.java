package sample.cwe652;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class getCookiesServlet_executeQuery {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		String data = "";
		
		{
			Cookie cookieSources[] = request.getCookies();
			if(cookieSources != null)
			{
				data = cookieSources[0].getValue();
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
