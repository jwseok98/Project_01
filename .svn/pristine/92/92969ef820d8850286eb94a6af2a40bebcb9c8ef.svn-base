package sample.cwe732;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KRD_203_basic_File_0101_bad {
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		File file = new File("C:\\report.txt");
		
		// flaw
		file.setExecutable(true);
		file.setReadable(true);
		file.setWritable(true);
	}
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
		File file = new File("C:\\report.txt");
		
		file.setExecutable(false);
		file.setReadable(false);
		file.setWritable(false);
	}
}
