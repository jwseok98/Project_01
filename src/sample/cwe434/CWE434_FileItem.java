package sample.cwe434;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class CWE434_FileItem extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		try {
			if(ServletFileUpload.isMultipartContent(request)) {
				fileUpload_bad(request, response);				
			}
		}catch(Exception e) {
			if(e instanceof ServletException) {
				throw (ServletException)e;
			}
		}
	}
	
	private void fileUpload_bad(HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
		File repository = new File("/temp/upload-tmp");
		
		DiskFileItemFactory factory = new DiskFileItemFactory(1024, repository);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(-1);;
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			
			Iterator<FileItem> iterator = list.iterator();
			while(iterator.hasNext()) {
				FileItem fileItem = iterator.next();
				String fileName = fileItem.getName();
				
				// POTENTIAL
				fileItem.write(new File("/temp/upload/" + fileName));
			}
		} catch(FileUploadException fue) {
			fue.printStackTrace();
		}
	}
	
	
}
