package sample.cwe652;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.cwe23_36_99.IO;

public class fromDB_executeQuery {
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String data = System.getenv("ADD");	
		
		try{
			con = IO.getDBConnection();
			ps = con.prepareStatement("select * from tuser");
			rs = ps.executeQuery();
			data = rs.getString(1);
		}catch(Exception e){
			throw e;
		}finally{
			if(rs != null) con.close();
			if(ps != null) con.close();
			if(con != null) con.close();
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
