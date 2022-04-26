/*
 * 참조: 행정안전부 SW개발보안가이드 - SQL삽입 - 안전하지않은코드
 */
package sample.cwe89_2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SQLi_servlet_jdbc_basic_bad01 extends HttpServlet {
	
	private static final long serialVersionUID = -6467800071672997227L;

	
	public void service(HttpServletRequest request, HttpServletResponse response, String abc) throws ServletException, IOException {
		
		String username = request.getParameter("usernm");
		String password = request.getParameter("passwd");
		
		String loginSql = "SELECT * FROM T_USER WHERE username='" + username + "' and password='" + password + "'";
//		String loginSql = "SELECT * FROM T_USER WHERE username='" + abc + "'";
//		String loginSql = "SELECT * FROM T_USER WHERE username=abc";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc");
			stmt = conn.createStatement();
			
			loginSql = Fix.filt(loginSql);
			
			/* POTENTIAL FLAW */ 
			rs = stmt.executeQuery(loginSql);
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException sqlee) {}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch(SQLException sqlee) {}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException sqlee) {}
			}
		}
	}	
}
