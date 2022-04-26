package sample.cwe652;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PropertiesFile_executeQuery {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String data = "";
    	Properties props = new Properties();
		FileInputStream finstr = null;
		
    	try{
    		String dir = System.getProperty("user.dir");
    		finstr = new FileInputStream(dir + "/src");
    		props.load(finstr);
    		
			data = props.getProperty("data");
						
    	}catch(Exception e){
    		e.printStackTrace();
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
