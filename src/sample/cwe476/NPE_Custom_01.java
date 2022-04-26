package sample.cwe476;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NPE_Custom_01 {

	public void bad01() {
		File dir = new File("powers");

		String[] childs = dir.list();

		// POTENTIAL FLAW: 1
		for (String child : childs) {
			File file = new File(dir, child);
		}

		// POTENTIAL FLAW: 2
		for (int i=0; i<childs.length; i++) {
			File file = new File(dir, childs[i]);
		}
	}

	public void bad02() {
		File dir = new File("powers");

		File[] childs = dir.listFiles();

		// POTENTIAL FLAW
		for (File child : childs) {
			System.out.println(child);
		}
	}

	public void bad03() {
		File file = null;

		// POTENTIAL FLAW
		file.toString();
	}

	public void bad04() {
		File file = new File("D:/qqqq");
		File parent = null;

		if (file.getParentFile() != null) {
			parent = file.getParentFile();
		}

		// POTENTIAL FLAW
		parent.mkdirs();
	}

	public void bad05() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM USER";

			conn = DriverManager.getConnection("connectionstring");
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				// POTENTIAL FLAW
				rs.close();

				// POTENTIAL FLAW
				stmt.close();

				// POTENTIAL FLAW
				conn.close();
			} catch (SQLException sss) {

			}
		}
	}

	public void good01_1() {
		File dir = new File("powers");

		String[] childs = dir.list();

		if (childs != null) {
			// FIXED
			for (String child : childs) {
				File file = new File(dir, child);
			}
		}
	}

	public void good01_2() {
		File dir = new File("powers");

		String[] childs = dir.list();

		if (childs == null) {
			return; 
		}

		// FIXED
		for (String child : childs) {
			File file = new File(dir, child);
		}
	}

	public void good01_3() {
		File dir = new File("powers");

		if (dir.exists()) {
			String[] childs = dir.list();

			// FIXED
			for (String child : childs) {
				File file = new File(dir, child);
			}
		}
	}

	public void good01_4() {
		File dir = new File("powers");

		if (dir.isDirectory()) {
			String[] childs = dir.list();

			// FIXED
			for (String child : childs) {
				File file = new File(dir, child);
			}
		}
	}

	public void good01_5() {
		File dir = new File("powers");

		if (!dir.isDirectory()) {
			return;
		}

		String[] childs = dir.list();

		// FIXED
		for (String child : childs) {
			File file = new File(dir, child);
		}
	}

	public void good05() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM USER";

			conn = DriverManager.getConnection("connectionstring");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);

			if (rs.next()) {

				String uId = rs.getString("UID");
				
				String uName = rs.getString("UNAME");

				String uClass = rs.getString("UCLASS");
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				// POTENTIAL FLAW
				rs.close();

				// POTENTIAL FLAW
				stmt.close();

				// POTENTIAL FLAW
				conn.close();
			} catch (SQLException sss) {

			}
		}
	}

}
