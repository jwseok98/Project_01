package sample.cwe367;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import sample.IO;

public class KRD_301_TOC_TOU__basic_canRead_0101_bad {
	
	public void bad(){
		
		BufferedReader bufread =null;
		InputStreamReader inread = null;
		FileInputStream finstr = null;
		
		String line= "";
		
		try {
			
			finstr = new FileInputStream("c:\\toctou.txt");
			inread = new InputStreamReader(finstr);
			bufread = new BufferedReader(inread);
			
			IO.writeLine("Intentional delay. Hit return to continue");
			bufread.readLine();
			
			while ((line = bufread.readLine()) != null) {
				IO.writeLine(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
