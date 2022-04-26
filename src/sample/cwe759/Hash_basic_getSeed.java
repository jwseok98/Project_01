package sample.cwe759;

import java.security.MessageDigest;

public class Hash_basic_getSeed {
	
	public void bad() throws Exception{
		
		MessageDigest hash = MessageDigest.getInstance("SHA-512");		
		
		byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));		
		
		IO.writeLine(IO.toHex(hashv));		
	}
	public void good() throws Exception
	{
		byte [] salt = {1,1,1,1,1,1,1,1};		
		MessageDigest hash = MessageDigest.getInstance("SHA-512");		
		hash.reset();
		hash.update(salt);
		byte[] hashv = hash.digest("hash me".getBytes("UTF-8"));		
		
		IO.writeLine(IO.toHex(hashv));		
	}	
}
