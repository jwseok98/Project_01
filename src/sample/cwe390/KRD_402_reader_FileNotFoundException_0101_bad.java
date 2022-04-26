package sample.cwe390;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class  KRD_402_reader_FileNotFoundException_0101_bad {
	
	public void bad() throws Exception{
		
		File f = new File ("C:\\data.txt");
		BufferedReader buffread = null;
		FileInputStream fis = null;
		InputStreamReader isread = null;
		
		String data = "";
		
		try {
			
			fis = new FileInputStream(f);
			isread = new InputStreamReader(fis, "UTF-8");
			buffread = new BufferedReader(isread);
			
			data = buffread.readLine();
			
		} catch (FileNotFoundException fe) {
			// Exception catch 이후, Exception 에 대한 적절힌 처리가 없다.
		}
		
	}
	
	public void good() throws Exception{
		
		File f = new File ("C:\\data.txt");
		BufferedReader buffread = null;
		FileInputStream fis = null;
		InputStreamReader isread = null;
		
		String data = "";
		
		try {
			
			fis = new FileInputStream(f);
			isread = new InputStreamReader(fis, "UTF-8");
			buffread = new BufferedReader(isread);
			
			data = buffread.readLine();
			
		} catch (FileNotFoundException fe) {
			// Exception catch 이후, Exception 처리
			fe.printStackTrace();
		}
		
	}
}
