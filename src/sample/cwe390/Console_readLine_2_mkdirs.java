package sample.cwe390;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;


public class Console_readLine_2_mkdirs {
	public void bad(){
		
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		
		String data = "";
		
		try {
	
			instrread = new InputStreamReader(System.in,"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String dirs = data;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(dirs);
		} catch (FileNotFoundException fe) {
			// Exception catch ����, Exception �� ���� ������ ó���� ����.
		}
	}
	
	public void good(){
		
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		
		String data = "";
		
		try {
	
			instrread = new InputStreamReader(System.in,"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String dirs = data;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(dirs);
		} catch (FileNotFoundException fe) {
			// Exception catch ����, Exception ó��
			fe.printStackTrace();
		}
	}
}
