package sample.dataflow.pathtraversalandresourceinjection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletResponse;

public class FileDownloadService {
	
	public void downloadFile(File uploadDir, String fileName, HttpServletResponse response) throws Exception {
		
		// POTENTIAL FLAW: Relative Path Traversal
		File file = new File(uploadDir, fileName);
		
		if (file.exists() && file.isFile()) {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Description", "attachment; filename=" + fileName);
			
			BufferedReader reader = null;
			BufferedWriter writer = null;
			
			try {
				reader = new BufferedReader(new FileReader(file));
				writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
				
				char[] buff = new char[1024 * 5];
				int len = -1;
				
				while ((len = reader.read(buff)) != -1) {
					writer.write(buff, 0, len);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException ioe) {}
				}
			}
		} else {
			response.setContentType("text/html");
			response.getWriter().println("<script> alert('error'); </script>");
		}
	}
}
