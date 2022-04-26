package sample.cwe321;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sample.cwe539.IO;

public class KRD_210_basic_SecretKeySpec_0101_bad {
	
	public void bad() throws Exception {
		
		String data;
		data = "23~j;asn!@#/>as";
		
		String sToEncrypt = "Super secret Squirrel";
		
		byte [] bToEncrypt = sToEncrypt.getBytes("UTF-8");
		SecretKeySpec sKeySpec = new SecretKeySpec(data.getBytes(), "AES");
		
		Cipher aesCipher = Cipher.getInstance("AES");
		aesCipher.init(Cipher.ENCRYPT_MODE, sKeySpec);		
		
		byte[] bCipherText = aesCipher.doFinal(bToEncrypt);
		
		IO.writeLine(IO.toHex(bCipherText));
		
		
	}
	
}
