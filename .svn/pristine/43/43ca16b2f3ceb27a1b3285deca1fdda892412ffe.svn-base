package sample.cwe326;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KRD_208_Cryptographic_Issues__basic_initialize_0101_bad {
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
