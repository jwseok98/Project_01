package sample.cwe476;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NP_exception_object_good01 {
	
	private String error = "";
	private String sql = "";
	
	public ArrayList getIpList() throws Exception {
		ResultSet rs                 = null;
        Connection con               = null;
        PreparedStatement pstmt      = null;
        ArrayList list = new ArrayList();
 
        try {
            con = DriverManager.getConnection("url");
 
            sql = "SELECT NUM, COM_SEQ, SUB_DESC, DOMAIN_DESC, DOMAIN_TXT, CREATED, DOMAIN_SEC, SUB_SEC, CHECK_YN, rep_value      \n"+
                  "FROM (SELECT ROWNUM NUM, COM_SEQ, SUB_DESC, DOMAIN_DESC, DOMAIN_TXT, CREATED,  \n"+
                  "              DOMAIN_SEC, SUB_SEC, CHECK_YN, rep_value                           \n"+
                  "       FROM( SELECT TO_CHAR(A.CREATED,'YYYY-MM-DD HH24:MI:SS') AS CREATED,       \n"+
                  "                     B.DOMAIN_DESC, C.SUB_DESC, A.COM_SEQ, A.DOMAIN_TXT,         \n"+
                  "                     A.DOMAIN_SEC, A.SUB_SEC, A.CHECK_YN, nvl(d.rep_value,'0.3') rep_value \n"+
                  "              FROM TB_WIP A, TB_DOMAIN_BASE B, TB_DOMAIN_SUB C,    \n"+
                  "                    TB_DOMAIN_REPUTATION D    \n"+
                  "              WHERE A.DOMAIN_SEC = B.DOMAIN_SEC(+) AND A.DEL_YN = 'N'            \n"+
                  "              AND A.DOMAIN_SEC = C.DOMAIN_SEC(+) AND A.SUB_SEC = C.SUB_SEC(+)    \n"+
                  "              AND a.domain_txt = d.domain(+)                      \n";
            
            sql += "          order by A.CHECK_YN, A.CREATED desc  \n";
            sql += "            )                            \n"+
                   "        )                                \n";

            //System.out.println(sql.toString());
            pstmt   = con.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
 
            while(rs.next()) {
            	Map map = new HashMap();
            	
            	map.put("NUM", rs.getInt("NUM"));
            	map.put("COM_SEQ", rs.getString("COM_SEQ"));
            	map.put("SUB_DESC", rs.getString("SUB_DESC"));
            	map.put("DOMAIN_DESC", rs.getString("DOMAIN_DESC"));
            	map.put("DOMAIN_TXT", rs.getString("DOMAIN_TXT"));
            	map.put("CREATED", rs.getString("CREATED"));
            	map.put("DOMAIN_SEC", rs.getString("DOMAIN_SEC"));
            	map.put("SUB_SEC", rs.getString("SUB_SEC"));
            	map.put("rep_value", rs.getFloat("rep_value"));
            	map.put("CHECK_YN", rs.getString("CHECK_YN"));
 
                list.add(map);
            } //while end
        } catch ( java.sql.SQLException ex ) {
            ex.printStackTrace();
            error = ex.toString();
        } catch ( Exception ex ) {
            ex.printStackTrace();
            /*
             * FIX..
             * ex 변수는 null 이 아님.
             */
            error = ex.toString();
        } finally {
            if ( pstmt != null ) pstmt.close();
            if ( rs   != null )  rs.close();
            if ( con != null )  con.close();
        }
        return list;
	}
}
