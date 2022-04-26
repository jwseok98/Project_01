package sample.cwe390;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestInputFile {
	public void bad() {
		
		String fileName = "C:/a.txt";
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(fileName);
		} catch(FileNotFoundException fnfe) {
			
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("aaa");
	}
	
	public void good() {
		
		String fileName = "C:/a.txt";
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(fileName);
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("aaa");
	}
}