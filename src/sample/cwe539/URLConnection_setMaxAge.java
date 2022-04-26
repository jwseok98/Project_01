package sample.cwe539;

import java.io.*;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;

public class URLConnection_setMaxAge {	

	public void bad() throws Exception{
		
		// URL ��ü�� �����.		
		URL url = new URL("http://192.168.0.100/taint.html/");
		
		//URL ��ü���� URLConnection �����Ѵ�.
		URLConnection con = url.openConnection();
		
		InputStream instream;
		// BufferedReader �� �����Ѵ�.
		BufferedReader buffread = null;
		// InputStreamReader �� �����Ѵ�.
		InputStreamReader instrread = null;
		
		// String data �� �����Ѵ�
		String data = "";
				
		try {
			//InputStream�� ��´�.
			instream = con.getInputStream();
			// �Է� ���� InputStreamReader �ν��Ͻ��� �����Ѵ�.
			instrread = new InputStreamReader(instream , "utf-8");;
			// InputStreamReader�� ���۰�ü�� �����Ѵ�.
			buffread = new BufferedReader(instrread);
			
			// data�� buffread�� �����͸� �о�鿩 ��´�
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// ���ڿ� name ������ �����ϰ� ���� "Name" �� ��´�
		String name = "Name";
		// ���ڿ� value ������ �����ϰ� ���� "ABC" �� ��´�
		String value = "ABC";
		
		// ��Ű�� �����ϰ� name, value���� �޴´�
		HttpCookie hc = new HttpCookie(name, value);
		
		// ������ ��Ű�� long�� �ʴ��� �ִ밪�� �����Ѵ�. 
		hc.setMaxAge(Integer.valueOf(data));
		
		// �ֿܼ��� ���� ����Ѵ�..
		System.out.println("Maximum age of the cookie is: "+ hc.getMaxAge());		
	}
	
}
