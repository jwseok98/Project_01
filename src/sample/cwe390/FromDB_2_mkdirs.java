package sample.cwe390;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import sample.cwe539.IO;

public class FromDB_2_mkdirs {
	
	public void bad(){
		
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
		
		String dirs = data;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(dirs);
		} catch (FileNotFoundException fe) {
			// Exception catch 이후, Exception 에 대한 적절힌 처리가 없다.
		}
	}
	
	public void good(){
		
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
		
		String dirs = data;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(dirs);
		} catch (FileNotFoundException fe) {
			// Exception catch 이후, Exception 처리
			fe.printStackTrace();
		}
	}
}
