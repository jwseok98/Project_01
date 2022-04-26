package sample.dataflow.pathtraversalandresourceinjection;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadServlet2 extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2891512589605786743L;

	
	/**
	 * 파일 다운로드 서블릿
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File uploadDir = new File(request.getServletContext().getRealPath("/"));
		
		String fileName = request.getParameter("filename");
		
		FileDownloadService fileDownloadService = new FileDownloadService();
		
		try {
			fileDownloadService.downloadFile(uploadDir, fileName, response);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
