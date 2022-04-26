package sample.cwe434;

import java.io.*;
import java.net.*;
import java.util.*;

public class KRD_105_tcp_getOriginalFilename_0101_bad {
	
	public void bad() throws Exception
	{
		Socket sock = null;
		BufferedReader buffread = null;
		InputStreamReader instrread = null;
		
		String data = "";
		
		try{
			sock = new Socket("192.168.0.100", 9000);			
			instrread = new InputStreamReader(sock.getInputStream(),"UTF-8");
			buffread = new BufferedReader(instrread);
			
			data = buffread.readLine();
			
		}catch(Exception e){
			throw e;
		}finally{
			if(buffread != null) buffread.close();
			if(instrread != null) instrread.close();				
			if(sock != null) sock.close();
		}
				
		Enumeration formNames = MultipartUtils.getFormnames();
		MultipartFile multi = MultipartUtils.getMultipartFile();
		String fileInput = "";
		String fileName = "";
		String type = "";
		String originFileName = "";
		File fileObj = null;
		
		String fileExtend = "";
		String fileSize = "";
		
		while(formNames.hasMoreElements())
		{
			fileInput = (String)formNames.nextElement();
			fileName = multi.getFilesystemName(fileInput);
			
			if(fileName != null)
			{
				type = multi.getContentType(fileInput);
				fileObj = multi.getFile(fileInput);
				
				originFileName = multi.getOriginalFileName(data + fileInput);
				fileExtend = fileName.substring(fileName.lastIndexOf(".")+1);
				fileSize = String.valueOf(fileObj.length());
			}
		}
		
		System.out.println(type + ":" + originFileName + ":" + fileSize + ":" + fileExtend);
	}
	
	public void good() throws Exception
	{
		
		String data = "myFilename";				
		
		Enumeration formNames = MultipartUtils.getFormnames();
		MultipartFile multi = MultipartUtils.getMultipartFile();
		String fileInput = "";
		String fileName = "";
		String type = "";
		String originFileName = "";
		File fileObj = null;
		
		String fileExtend = "";
		String fileSize = "";
		
		while(formNames.hasMoreElements())
		{
			fileInput = (String)formNames.nextElement();
			fileName = multi.getFilesystemName(fileInput);
			
			if(fileName != null)
			{
				type = multi.getContentType(fileInput);
				fileObj = multi.getFile(fileInput);
				
				originFileName = multi.getOriginalFileName(data + fileInput);
				fileExtend = fileName.substring(fileName.lastIndexOf(".")+1);
				fileSize = String.valueOf(fileObj.length());
			}
		}
		
		System.out.println(type + ":" + originFileName + ":" + fileSize + ":" + fileExtend);
	}
}
