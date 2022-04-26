package sample.cwe476;

import java.sql.ResultSet;
import java.sql.SQLException;

import sample.support.DBHandler;

public class NP_ResultSet_good02 {
	
	public void boardHiList_good() throws Exception {
		
		DBHandler db = null;
		ResultSet rs = null;
		String b_Type = null;
		StringBuffer sb = null;
		
		db = new DBHandler(this);
		sb = new StringBuffer();
	
		
		rs = db.executeQuery("select");

		if (rs.next()) {
			/* FIX..
			 * DBHandler.executeQuery() 메소드에서 null 이 반환되지 않으므로 rs 변수는 null 값이 할당되지 않음.
			 */
			b_Type = rs.getString("B_TYPE");
		}
		
		sb.append("SELECT ............... \n");
		sb.append("FROM ............... \n");
		
		
		if ("08".equals(b_Type)) {
			/* FIX..
			 * sb 변수는 null이 아니다.
			 */
			sb.append("WHERE1 ............... \n");
		} else {
			/* FIX..
			 * sb 변수는 null이 아니다.
			 */
			sb.append("WHERE2 ............... \n");
		}
		
		sb.append("ORDER BY ............... \n");
	}
}