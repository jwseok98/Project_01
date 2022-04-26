package sample.cwe89_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	public List<ArticleVO> getArticles() throws ClassNotFoundException, SQLException {
		List<ArticleVO> articles = new ArrayList<>();
		
		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			dbConn = DriverManager.getConnection("jdbc:mysql:localhost/board", "mysql", "1q2w3e");
			stmt = dbConn.createStatement();
			
			String sql = "SELECT * FROM BOARD";
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ArticleVO vo = new ArticleVO();
				vo.setId(rs.getInt("ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setWriteTime(rs.getLong("WRITE_TIME"));
				vo.setWriteUser(rs.getString("WRITE_USER"));
				articles.add(vo);
			}
		} finally {
			close(rs);
			close(stmt);
			close(dbConn);
		}
		return articles;
	}
	
	/**
	 * BAD METHOD
	 */
	public List<ArticleVO> getArticles(String title) throws ClassNotFoundException, SQLException {
		List<ArticleVO> articles = new ArrayList<>();
		
		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			dbConn = DriverManager.getConnection("jdbc:mysql:localhost/board", "mysql", "1q2w3e");
			stmt = dbConn.createStatement();
			
			String sql = "SELECT * FROM BOARD WHERE TITLE='" + title + "'";
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ArticleVO vo = new ArticleVO();
				vo.setId(rs.getInt("ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setWriteTime(rs.getLong("WRITE_TIME"));
				vo.setWriteUser(rs.getString("WRITE_USER"));
				articles.add(vo);
			}
		} finally {
			close(rs);
			close(stmt);
			close(dbConn);
		}
		return articles;
	}
	
	/**
	 * BAD METHOD
	 */
	public List<ArticleVO> getArticles_2(String title) throws ClassNotFoundException, SQLException {
		List<ArticleVO> articles = new ArrayList<>();
		
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			dbConn = DatabaseSupportUtils.getConnection();
			
			String sql = "SELECT * FROM BOARD WHERE TITLE='" + title + "'";
			
			pstmt = dbConn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while (rs.next()) {
				ArticleVO vo = new ArticleVO();
				vo.setId(rs.getInt("ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setWriteTime(rs.getLong("WRITE_TIME"));
				vo.setWriteUser(rs.getString("WRITE_USER"));
				articles.add(vo);
			}
		} finally {
			close(rs);
			close(pstmt);
			close(dbConn);
		}
		return articles;
	}
	
	/**
	 * BAD METHOD
	 */
	public ArticleVO getArticle(int id) throws ClassNotFoundException, SQLException {		
		Connection dbConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			dbConn = DriverManager.getConnection("jdbc:mysql:localhost/board", "mysql", "1q2w3e");
			stmt = dbConn.createStatement();
			
			String sql = "SELECT * FROM BOARD WHERE ID=" + id;
			
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				ArticleVO vo = new ArticleVO();
				vo.setId(rs.getInt("ID"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setWriteTime(rs.getLong("WRITE_TIME"));
				vo.setWriteUser(rs.getString("WRITE_USER"));
				return vo;
			}
		} finally {
			close(rs);
			close(stmt);
			close(dbConn);
		}
		return null;
	}
	
	public void remove(int id) throws ClassNotFoundException, SQLException {
		Connection dbConn = null;
		PreparedStatement pstmt = null;
		
		try {
			dbConn = DatabaseSupportUtils.getConnection();
			
			String sql = "DELETE FROM BOARD WHERE ID=" + id;
			
			pstmt = dbConn.prepareStatement(sql);
			pstmt.execute();
		} finally {
			close(pstmt);
			close(dbConn);
		}
	}
	
	
	/*******************************************************
	 * Util Methods
	 ******************************************************/ 
	
	private static void close(Connection connection) {
		if (connection != null) {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException sqle) {
			}
		}
	}
	
	private static void close(Statement statement) {
		if (statement != null) {
			try {
				if (!statement.isClosed()) {
					statement.close();
				}
			} catch (SQLException sqle) {
			}
		}
	}
	
	private static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				if (!resultSet.isClosed()) {
					resultSet.close();
				}
			} catch (SQLException sqle) {
			}
		}
	}
}
