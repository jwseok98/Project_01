package sample.cwe330;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import sample.cwe539.IO;

public class FromDB_2_Random {
	
	public void bad(){
		
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		String data = "";
		
		try {
			con = IO.getDBConnection();
			
			statement = con.prepareStatement("select name from users where id=0");
			rs = statement.executeQuery();
			rs.next();
			
			data = rs.getString(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Random rand = new Random();
		
		rand.setSeed(Integer.valueOf(data));
		IO.writeLine("Random int: "+ rand.nextInt(100));
		
	}
	
}
