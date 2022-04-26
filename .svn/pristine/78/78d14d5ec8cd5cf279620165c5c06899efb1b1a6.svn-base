package sample.cwe23_36_99;

import java.io.*;
import java.sql.*;

public class KRD_102_fromDB_File_0101_bad {
	
	public void bad() throws Exception
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String data = "";
		String root = "D:/evenstar/ok";			
		
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
		
		
		
		if(data != null)
		{
			File f1 = new File(data + "102-1.txt");
			File f2 = new File("C:\\102-2.txt");
			
			f1.renameTo(f2);
			
			File f3 = new File(data);
			File f4 = new File("C:\\102-2.txt");
			
			f3.renameTo(f4);
			
			File f5 = new File(root + data);
			File f6 = new File("C:\\102-2.txt");
			
			f5.renameTo(f6);
		}
	}
}
