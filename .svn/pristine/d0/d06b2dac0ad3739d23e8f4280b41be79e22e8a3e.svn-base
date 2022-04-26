/*
 * 참조: 없음. 스프링 MVC 기반 JDBC 샘플 - 안전한코드
 */
package sample.cwe89.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SQLi_spring_jdbc_basic_good01 {
	
	@RequestMapping(value = "/login")
	public String login(@RequestParam Map<String,String> paramMap) {
		
		String username = paramMap.get("usernm");
		String password = paramMap.get("passwd");
		
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
			
			if (rs.next()) {
				return "success";
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if(rs != null) {
				try { 
					rs.close();
				} catch(SQLException sqle) {}
			}
			if(pstmt != null) {
				try { 
					pstmt.close();
				} catch(SQLException sqle) {}
			}
			if(conn != null) {
				try { 
					conn.close();
				} catch(SQLException sqle) {}
			}
		}
		return "fail";
	}
	
	@RequestMapping(value = "/board/notice/view")
	public ModelAndView viewNoticeArticle(String articleId) {
		
		String query = "SELECT * FROM T_NOTICE WHERE ARTICLE_ID=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, articleId);
			
			/* FIX.. */
			rs = pstmt.executeQuery(query);
			
			if (rs.next()) {
				ModelAndView modelAndView = new ModelAndView("view");
				modelAndView.addObject("TITLE", rs.getString("title"));
				modelAndView.addObject("CONTENT", rs.getString("content"));
				modelAndView.addObject("WRITTER", rs.getString("writter"));
				return modelAndView;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if(rs != null) {
				try { 
					rs.close();
				} catch(SQLException sqle) {}
			}
			if(pstmt != null) {
				try { 
					pstmt.close();
				} catch(SQLException sqle) {}
			}
			if(conn != null) {
				try { 
					conn.close();
				} catch(SQLException sqle) {}
			}
		}
		return new ModelAndView("no-view");
	}
}