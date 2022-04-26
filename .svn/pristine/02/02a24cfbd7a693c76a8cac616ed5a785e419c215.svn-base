package sample.cwe326;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Basic_initialize_0102 {
	public void bad() throws Exception{
		
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		
		kpGen.initialize(1024);
		KeyPair pair = kpGen.generateKeyPair();
	}
	public void good() throws Exception{
		
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		
		kpGen.initialize(2048);
		KeyPair pair = kpGen.generateKeyPair();
	}
}
