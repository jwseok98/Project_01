/*
 * 참조: 행정안전부 SW개발보안가이드 - SQL삽입 - 안전한코드
 */
package sample.cwe89;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class SQLi_servlet_jdbc_basic_good01 extends HttpServlet {
	
	private static final long serialVersionUID = -6467800071672997227L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("usernm");
		String password = request.getParameter("passwd");
		
		String loginSql = "SELECT * FROM T_USER WHERE username=? and password=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc");
			
			pstmt = conn.prepareStatement(loginSql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			/* FIX.. */ 
			rs = pstmt.executeQuery();
			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(SQLException sqlee) {}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
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
