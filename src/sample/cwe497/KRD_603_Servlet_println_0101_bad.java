package sample.cwe497;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KRD_603_Servlet_println_0101_bad {
	
	public void bad(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		File f = new File("c:\\evenstar.txt");
		String path = f.getAbsolutePath();
		String fileName = f.getName();
		
		
		if (!f.exists()) {
			// �߿� �ý��� ��� ����
			response.getWriter().println("Not in path : "+ path);
		}
		else
		{	
			// �߿� ���� ���� ����
			response.getWriter().println(fileName + "exists");
		}	
	}

	public void good1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		File f = new File("c:\\evenstar.txt");
		String path = f.getAbsolutePath();
		String fileName = f.getName();
		
		
		if (!f.exists()) {
			// �߿� �ý��� ��� ����
			System.out.println("Not in path : "+ path);
		}
	}
	public void good(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String path = "c:\\Windows\\System32";
		String fileName = "config";
		File f = new File("c:\\evenstar.txt");
		
		if (!f.exists()) {
			// �߿� �ý��� ��� ���� ����
			response.getWriter().println("Not in path : "+ path);
		}
		else
		{	
			// �߿� ���� ���� ���� ����
			response.getWriter().println(fileName);
		}	
	}
}
