package ksc.framework.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import ksc.framework.exception.SysException;

import com.lgcns.laf.collection.LBox;
import com.lgcns.laf.collection.LVectorBox;
import com.lgcns.laf.env.LLog;
import com.lgcns.laf.exception.LException;
import com.lgcns.laf.page.dao.LPageFactory;
/**
 * 최상위 DAO.
 * 모든 업무 DAO는 반드시 SuperOracleDAO를 상속 받아 작성하여야 한다.
 */
public class SuperOracleDAO {
    /**
     * DataBase Connection object
     */
    private Connection conn = null;
    /**
     * pre-compiled SQL statement 실행을 위한 PreparedStatement object
     */
    protected PreparedStatement prepStmt = null;
    /**
     * pre-compiled SQL statement(Stored Procedure call) 실행을 위한 CallableStatement object
     */
    protected CallableStatement callStmt = null;
    /**
     * Query 결과를 저장하는 ResultSet object
     */
    protected ResultSet rset = null;
    /**
     * <pre>
     * SuperOracleDAO의 기본 생성자
     * </pre>
     */
    public SuperOracleDAO() {
        super();
    }
    /**
     * <pre>
     * Connection을 받아 세팅한다.
     * </pre>
     * 
     * @param conn DataBase Connection object
     */
    public SuperOracleDAO(Connection conn) {
        this.conn = conn;
    }
    /**
     * <pre>
     * pre-compiled SQL statement를 담고 있는 PreparedStatement object를 생성한다.
     * </pre>
     * 
     * @param sql ?를 포함하고 있는 SQL statement
     * @throws SysException
     */
    protected void openPrepStmt(String sql) throws SysException {
        try {
            prepStmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new SysException(e);
        } finally {
        }
    }
    /**
     * <pre>
     * pre-compiled SQL statement를 담고 있는 CallableStatement object를 생성한다.
     * </pre>
     * 
     * @param sql ?를 포함하고 있는 SQL statement
     * @throws SysException
     */
    protected void openCallStmt(String sql) throws SysException {
        try {
            callStmt = conn.prepareCall(sql);
        } catch (SQLException e) {
            throw new SysException(e);
        } finally {
        }
    }
    /**
     * <pre>
     * JDBC관련 Resource를 release한다.
     * </pre>
     */
    protected void close() throws SysException {
        try {
            if (this.rset != null) {
                this.rset.close();
                this.rset = null;
            }
            if (this.prepStmt != null) {
                this.prepStmt.close();
                this.prepStmt = null;
            }
            if (this.callStmt != null) {
                this.callStmt.close();
                this.callStmt = null;
            }
        } catch (Exception e) {
            throw new SysException(e);
        }
    }
    /**
     * <pre>
     * Paging 처리.
     * </pre>
     * 
     * @param sql
     * @param bindVars
     * @param box
     * @param pageSpec
     * @return LVectorBox 조회 결과
     * @throws LException
     */
    protected LVectorBox executeLPageQuery(String sql, Vector bindVars, LBox box, String pageSpec) throws LException {
        LVectorBox vBox = null;
        try {
            LPageFactory factory = new LPageFactory();
            vBox = factory.createStatement(pageSpec).execute(conn, sql, bindVars, box, pageSpec);
        } catch (LException e) {
            LLog.err.println("SuperOracleDAO.executePageQuery() failed : " + e.getMessage());
            throw e;
        } finally {
        }
        return vBox;
    }
    /**
     * <pre>
     * 단일 건을 조회한 후 결과를 LBox에 담아 반환한다.
     * </pre>
     * 
     * @return LBox 조회 결과
     * @throws LException
     */
    protected LBox executeLQuery() throws LException {
        LBox box = new LBox("retBox");
        try {
            rset = prepStmt.executeQuery();
            box = getBoxFromRSet(rset);
        } catch (SQLException e) {
            throw new SysException(e);
        }
        return box;
    }
    /**
     * <pre>
     * 여러 건을 조회한 후 결과를 LVectorBox에 담아 반환한다.
     * </pre>
     * 
     * @return LVectorBox 조회 결과
     * @throws LException
     */
    protected LVectorBox executeLListQuery() throws LException {
        LVectorBox vBox = new LVectorBox("retBox");
        try {
            rset = prepStmt.executeQuery();
            vBox = getVBoxFromRSet(rset);
        } catch (SQLException e) {
            throw new SysException(e);
        }
        return vBox;
    }
    /**
     * <pre>
     * 단일 건을 담고 있는 ResultSet을 LBox로 변환한다.
     * </pre>
     * 
     * @param rset 변환할 ResultSet
     * @return LBox 조회 결과.
     * @throws LException
     */
    protected LBox getBoxFromRSet(ResultSet rset) throws LException {
        int numCols = 0;
        String[] columnName = null;
        LBox rBox = new LBox("retBox");
        ResultSetMetaData rsmd = null;
        try {
            if (rset != null) {
                rsmd = rset.getMetaData();
                numCols = rsmd.getColumnCount();
                columnName = new String[numCols + 1];
                // rownum을 세팅
                columnName[0] = "rows";
                //Select절의 Column List를 fetch
                for (int inx = 1; inx < numCols + 1; inx++) {
                    columnName[inx] = rsmd.getColumnLabel(inx);
                }
                //converter = new Converter( rs );
                if (rset.next()) {
                    for (int inx = 1; inx < numCols + 1; inx++) {
                        rBox.put(fixColumnName(columnName[inx]), rset.getString(columnName[inx]));
                    }
                    rBox.put("rows", "1");
                } else {
                    rBox.put("rows", "0");
                }
            }
        } catch (SQLException e) {
            LLog.err.println("SuperOracleDAO.getBoxFromRSet() failed : " + e.getMessage());
            throw new SysException(e);
        } catch (Exception e) {
            LLog.err.println("Exception " + this.getClass().getName() + ".getResultData() " + e.toString());
            throw new LException(e);
        } finally {
        }
        return rBox;
    }
    /**
     * <pre>
     * 여러 건을 담고 있는 ResultSet을 LVectorBox로 변환한다.
     * </pre>
     * 
     * @param rset 변환할 ResultSet
     * @return LVectorBox 조회 결과.
     * @throws LException
     */
    protected LVectorBox getVBoxFromRSet(ResultSet rset) throws LException {
        int numCols = 0;
        int numRows = 0;
        String[] columnName = null;
        Vector[] columnData = null;
        LVectorBox vBox = new LVectorBox("retBox");
        ResultSetMetaData rsmd = null;
        try {
            if (rset != null) {
                rsmd = rset.getMetaData();
                numCols = rsmd.getColumnCount();
                columnName = new String[numCols + 1];
                columnData = new Vector[numCols + 1];
                // rownum을 세팅
                columnName[0] = "rows";
                columnData[0] = new Vector();
                //Select절의 Column List를 fetch
                for (int inx = 1; inx < numCols + 1; inx++) {
                    columnName[inx] = rsmd.getColumnLabel(inx);
                    columnData[inx] = new Vector();
                }
                //Converter converter = new Converter( rs );
                while (rset.next()) {
                    //칼럼당 vector하나를 할당하고 값을 넣음
                    for (int inx = 1; inx < numCols + 1; inx++) {
                        columnData[inx].addElement(rset.getString(columnName[inx]));
                    }
                    numRows++;
                }
                // List된 데이터 건수를 저장
                columnData[0].addElement(String.valueOf(numRows));
                // 각 Column Value Vector를 LVectorBox에 넣음
                for (int inx = 0; inx < numCols + 1; inx++) {
                    vBox.putVector(fixColumnName(columnName[inx]), columnData[inx]);
                }
            }
        } catch (SQLException e) {
            LLog.err.println("SuperOracleDAO.getVBoxFromRSet() failed : " + e.getMessage());
            throw new SysException(e);
        } catch (Exception e) {
            LLog.err.println("Exception " + this.getClass().getName() + ".getResultData() " + e.toString());
            throw new LException(e);
        } finally {
        }
        return vBox;
    }
    /**
     * <pre>
     * DB column 명을 Java naming rule에 맞게 수정한다.
     * ex) CD_GROUP -> cdGroup
     * </pre>
     * 
     * @param columnName 수정할 DB column 명
     * @return String Java naming rule에 맞게 수정된 DB column 명
     */
    protected String fixColumnName(String columnName) {
        if (columnName == null) {
            columnName = "";
        }
        columnName = columnName.toLowerCase();
        int inx = 0;
        inx = columnName.indexOf("_");
        if (inx == -1) {
            return columnName;
        }
        String head = "";
        String large = "";
        String tail = "";
        while ((inx = columnName.indexOf("_")) != -1) {
            if (inx == columnName.length() - 1) {
                return columnName = columnName.substring(0, columnName.length() - 1);
            }
            head = columnName.substring(0, inx);
            large = columnName.substring(inx + 1, inx + 2).toUpperCase();
            tail = columnName.substring(inx + 2, columnName.length());
            columnName = head + large + tail;
        }
        return columnName;
    }
    /**
     * <pre>
     * 현재 DAO 이름을 반환한다.
     * </pre>
     * 
     * @return String 현재 DAO 이름
     */
    protected String getDaoName() {
        String daoName = this.getClass().getName();
        //daoName = daoName.substring(daoName.lastIndexOf('.')+1);
        return daoName;
    }
}