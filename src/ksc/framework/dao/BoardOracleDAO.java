package ksc.framework.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import ksc.framework.exception.SysException;

import com.lgcns.laf.collection.LBox;
import com.lgcns.laf.collection.LVectorBox;
import com.lgcns.laf.exception.LException;

public class BoardOracleDAO extends SuperOracleDAO {
	
	private static final String LIST_QUERY = "SELECT * FROM BOARD";
	
	public BoardOracleDAO() throws SQLException {
		super(DriverManager.getConnection(""));
	}
	
	public LVectorBox listArticle(Vector vars, LBox box) throws LException {
		String pageSpec ="";
		
		return executeLPageQuery(LIST_QUERY, vars, box, pageSpec);
	}
	
	public void close() throws SysException {
		super.close();
	}
}