package sample.cwe476;

import org.w3c.dom.Document;

public class NPE_Custom_02 {
	
	public void bad01() {
		try {
			Document doc = XMLUtil.getDocument("<user>");
			
			XMLUtil.setString(doc, "MMU_ID", "id");
			XMLUtil.setString(doc, "MMU_NAME", "name");
			XMLUtil.setString(doc, "MMU_P", "p");
			
			String id = XMLUtil.getString(doc, "MMU_ID");
			
			// POTENTIAL FLAW
			if (id.equals("AA")) {
				System.out.println("non-secured");	
			}
			
			String name = XMLUtil.getString(doc, "MMU_NAME");
			String p = XMLUtil.getString(doc, "MMU_P");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void bad02() {
		String id = System.getProperty("id");
		
		// POTENTIAL FALW
		if (id == null && id.equals("user")) {
			System.out.println("A");
		}
		
		// POTENTIAL FALW
		if (id != null || id.isEmpty()) {
			System.out.println("A");
		}
		
		// POTENTIAL FALW
		if (!id.equals("user") || id == null) {
			System.out.println("A");
		}
	}
	
	public void bad03() {
		String id = System.getProperty("id");
		
		// POTENTIAL FALW
		if (id != null || id.isEmpty()) {
			System.out.println("A");
		}		
	}
	
	public void bad04() {
		String id = System.getProperty("id");
		
		// POTENTIAL FALW
		if (!id.equals("user") || id == null) {
			System.out.println("A");
		}
	}
	
	public void good01() {
		try {
			Document doc = XMLUtil.getDocument("<user>");
			
			XMLUtil.setString(doc, "MMU_ID", "id");
			XMLUtil.setString(doc, "MMU_NAME", "name");
			XMLUtil.setString(doc, "MMU_P", "p");
			
			String id = XMLUtil.getString(doc, "MMU_ID");
			
			if ("AA".equals(id)) {
				System.out.println("secured");
			}
			
			String name = XMLUtil.getString(doc, "MMU_NAME");
			String p = XMLUtil.getString(doc, "MMU_P");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String good02() {
		String result = null;
		
		try {
			Document doc = XMLUtil.getDocument("<user>");
			
			XMLUtil.setString(doc, "MMU_ID", "id");
			XMLUtil.setString(doc, "MMU_NAME", "name");
			XMLUtil.setString(doc, "MMU_P", "p");
			
			String id = XMLUtil.getString(doc, "MMU_ID");
			String name = XMLUtil.getString(doc, "MMU_NAME");
			String p = XMLUtil.getString(doc, "MMU_P");
			
			result = id;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
