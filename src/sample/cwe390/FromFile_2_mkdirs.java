package sample.cwe390;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class FromFile_2_mkdirs {
	
	public void bad(){
		
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String dirs = data;
	
		try {
			fis = new FileInputStream(dirs);
		} catch (FileNotFoundException fe) {
			// Exception catch 이후, Exception 에 대한 적절힌 처리가 없다.
		}
	}	
	public void good(){
		
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String dirs = data;
	
		try {
			fis = new FileInputStream(dirs);
		} catch (FileNotFoundException fe) {
			// Exception catch 이후, Exception 에 대한 적절힌 처리가 없다.
			fe.printStackTrace();
		}
	}
}
