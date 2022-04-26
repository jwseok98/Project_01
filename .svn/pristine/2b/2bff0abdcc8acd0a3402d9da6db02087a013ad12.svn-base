package sample.cwe476;

import java.sql.ResultSet;
import java.sql.SQLException;

import sample.support.DBHandler;

public class NP_ResultSet_good01 {
	
	public void boardHiList_good1() {
		
		DBHandler db = null;
		ResultSet rs = null;
		String b_Type = null;
		
		db = new DBHandler(this);
		
		try {
			rs = db.executeQuery("select");
			
			if (rs.next()) {
				/* FIX..
				 * DBHandler.executeQuery() 메소드에서 null 이 반환되지 않으므로 rs 변수는 null 값이 할당되지 않음.
				 */
				b_Type = rs.getString("B_TYPE");
			}
			
		} catch(SQLException e) {
			
		}
		
		if(db != null) try { db.end(); } catch (Exception e) {}
	}
	
	public void boardHiList_good2() throws Exception {
		
		DBHandler db = null;
		ResultSet rs = null;
		String b_Type = null;
		
		db = new DBHandler(this);
		
		rs = db.executeQuery("select");

		if (rs.next()) {
			/* FIX..
			 * DBHandler.executeQuery() 메소드에서 null 이 반환되지 않으므로 rs 변수는 null 값이 할당되지 않음.
			 */
			b_Type = rs.getString("B_TYPE");
		}
		
		db.end();
	}
}