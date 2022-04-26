package sample.cwe23_36_99.spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 경로조작 및 자원 삽입 (Relative Path Traversal)
 * @author gyh
 *
 */
@Controller
public class CWE22_rpt_spring_basic_bad_01 {
	
	@RequestMapping("/view")
	public void viewFile(String fileSeq, HttpServletRequest request, HttpServletResponse response) {
		File baseDir = new File("base");
		File file = new File(baseDir, "view-" + fileSeq);
		
		String viewName = request.getParameter("viewNameValue");
		
		File file2 = new File(baseDir, "view-" + viewName);
		
		PrintWriter writer = null;
		BufferedReader reader = null;
		BufferedReader reader2 = null;
		
		try {
			writer = response.getWriter();
			
			// POTENTIAL FLAW: 1
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				writer.println(line + "<BR>");
			}
			
			// POTENTIAL FLAW: 2
			reader2 = new BufferedReader(new FileReader(file2));
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ioe) {}
			}
		}
	
	}
}
