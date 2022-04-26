package sample.cwe326;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class Basic_initialize_0101 {
	public void bad() throws Exception{
		
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		
		kpGen.initialize(512);
		KeyPair pair = kpGen.generateKeyPair();
	}
}
