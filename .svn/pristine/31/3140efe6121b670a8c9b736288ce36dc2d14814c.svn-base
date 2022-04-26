package sample.cwe652;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class fromFile_executeQuery {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		File f = new File("C:\\data.txt");
		
		BufferedReader buffread = null;
		FileInputStream fis = null;
		InputStreamReader instrread = null;
		
		String data;
		
		try{			
			fis = new FileInputStream(f);
			instrread = new InputStreamReader(fis,"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();
			if(fis != null) fis.close();
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
