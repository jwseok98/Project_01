package sample.cwe521;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KRD_211_Servlet_2_getParameter_0101_bad {
	
	public void bad(HttpServletRequest request, HttpServletResponse response){
		
		Connection con = null;
		PreparedStatement sqlstatement = null;
		
		try {
			
			String url ="jdbc:mysql://192.168.0.100:3306/test";
			String user = "root";
			String dbpw = "apmsetup";
			String passwd = request.getParameter("passwd");
			
			con = DriverManager.getConnection(url, user, dbpw);
			
			//potential flaw
			sqlstatement = con.prepareStatement("insert into users (ID,name) values ('5',?)");
			sqlstatement.setString(1, passwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void good(HttpServletRequest request, HttpServletResponse response){
		
		Connection con = null;
		PreparedStatement sqlstatement = null;
		
		try {
			
			String url ="jdbc:mysql://192.168.0.100:3306/test";
			String user = "root";
			String dbpw = "apmsetup11111223333$";
			String passwd = request.getParameter("passwd");
			
			con = DriverManager.getConnection(url, user, dbpw);
			
			//potential flaw
			sqlstatement = con.prepareStatement("insert into users (ID,name) values ('5',?)");
			sqlstatement.setString(1, passwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
