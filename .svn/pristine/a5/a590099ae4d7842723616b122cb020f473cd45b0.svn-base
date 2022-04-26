package sample.cwe674;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KRD_302_Uncontrolled_Recursion__fromDB_2_recursion_0101_bad {
	
	public long bad(long n)	
	{
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
			
		String data = "";
			
		try {
			
			conn = IO.getDBConnection();
			
			statement = conn.prepareStatement("select name from users where id=0");
			rs = statement.executeQuery();
			rs.next();

			data = rs.getString(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		n = Long.parseLong(data);
			
		if (n < Long.MAX_VALUE) {
			long ret = n + bad(n-1);
			return ret;
		}
		else
		{
			IO.writeLine("Input value is too large to perform.");
			return 0;
		}
	}
	
}
