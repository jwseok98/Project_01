/*
 * 참조: 한국스마트카드 에서 사용중인 Devon 프레임워크 베이스
 */
package sample.cwe89;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import ksc.framework.dao.BoardOracleDAO;

import com.lgcns.laf.collection.LBox;
import com.lgcns.laf.collection.LVectorBox;
import com.lgcns.laf.exception.LException;

public class SQLi_use_smartcard_devon_bad01 {

	public List<LBox> bad_statement_executeQuery(String arg) {
		// userid, password 
		// passwd
		String query = "SELECT * FROM BORDER WHERE INDEX='" + arg + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<LBox> boxs = new ArrayList<LBox>();

		try {
			conn = DriverManager.getConnection("");
			stmt = conn.createStatement();
			
			/* POTENTIAL FLAW */ 
			rs = stmt.executeQuery(query);

			while(rs.next()) {
				int index = rs.getInt("index");
				String subject = rs.getString("subject");
				String content = rs.getString("content");

				LBox box = new LBox("ret");
				box.put("index", String.valueOf(index));
				box.put("subject", subject);
				box.put("content", content);

				boxs.add(box);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(Exception e) {}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch(Exception e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(Exception e) {}
			}
		}
		return boxs;
	}
	
	public List<LBox> bad_preparestatement_executeQuery(String arg) {

		String query = "SELECT * FROM BORDER WHERE INDEX='" + arg + "'";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<LBox> boxs = new ArrayList<LBox>();

		try {
			conn = DriverManager.getConnection("");
			stmt = conn.prepareStatement(query);
			
			/* POTENTIAL FLAW */ 
			rs = stmt.executeQuery(query);

			while(rs.next()) {
				int index = rs.getInt("index");
				String subject = rs.getString("subject");
				String content = rs.getString("content");

				LBox box = new LBox("ret");
				box.put("index", String.valueOf(index));
				box.put("subject", subject);
				box.put("content", content);

				boxs.add(box);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(Exception e) {}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch(Exception e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(Exception e) {}
			}
		}
		return boxs;
	}
	// admin
	public List<LBox> bad_callablestatement_executeQuery(String arg) {

		String query = "SELECT * FROM BORDER WHERE INDEX='" + arg + "'";

		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		List<LBox> boxs = new ArrayList<LBox>();

		try {
			conn = DriverManager.getConnection("");
			stmt = conn.prepareCall(query);
			
			/* POTENTIAL FLAW */
			rs = stmt.executeQuery(query);

			while(rs.next()) {
				int index = rs.getInt("index");
				String subject = rs.getString("subject");
				String content = rs.getString("content");

				LBox box = new LBox("ret");
				box.put("index", String.valueOf(index));
				box.put("subject", subject);
				box.put("content", content);

				boxs.add(box);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(Exception e) {}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch(Exception e) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(Exception e) {}
			}
		}
		return boxs;
	}

	public void good() {
		BoardOracleDAO dao = null;
		LVectorBox box = null;

		try {
			// admin 
			dao = new BoardOracleDAO();
			box = dao.listArticle(new Vector(), new LBox("ff"));
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (LException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(dao != null) {
				try {
					dao.close();
				} catch(Exception e) {}
			}
		}
	}
	
	public void bad222() {
		Integer value = new Integer(45);
	}
	
	public static void main(String[] args) {
//		System.out.println("adaad");
	}
}