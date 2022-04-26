package sample.cwe390;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

public class Environment_2_mkdirs {
	
	public void bad(){
		
		String data;
		
		Logger log_bad = Logger.getLogger("local-logger");
		
		data = System.getenv("ADD");
		
		String dirs = data;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(dirs);
		} catch (FileNotFoundException fe) {
			// Exception catch 이후, Exception 에 대한 적절힌 처리가 없다.
		}
	}
	
	public void good(){
		
		String data;
		
		Logger log_bad = Logger.getLogger("local-logger");
		
		data = System.getenv("ADD");
		
		String dirs = data;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(dirs);
		} catch (FileNotFoundException fe) {
			// Exception catch 이후, Exception 처리
			fe.printStackTrace();
		}
	}
}
