package sample.cwe134;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sample.cwe23_36_99.IO;

public class KRD_115_Uncontrolled_Format_String__fromDB_format_0101_bad{
	
	public void bad() throws Exception
	{
		
		String data = "";
				
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
					
		try{
			con = IO.getDBConnection();
			statement = con.prepareStatement("select * from tuser");
			rs = statement.executeQuery();
			rs.next();
			
			data = rs.getString(1);
		}catch(Exception e){
			throw e;
		}finally{
			if(rs != null) con.close();
			if(statement != null) con.close();
			if(con != null) con.close();
		}

		if(data != null)
		{
			System.out.format(data);	
		}		
	}
}
