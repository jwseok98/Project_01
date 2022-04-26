package sample.cwe539;

import java.io.*;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;

public class URLConnection_setMaxAge {	

	public void bad() throws Exception{
		
		// URL 객체를 만든다.		
		URL url = new URL("http://192.168.0.100/taint.html/");
		
		//URL 객체에서 URLConnection 연결한다.
		URLConnection con = url.openConnection();
		
		InputStream instream;
		// BufferedReader 을 선언한다.
		BufferedReader buffread = null;
		// InputStreamReader 을 선언한다.
		InputStreamReader instrread = null;
		
		// String data 를 선언한다
		String data = "";
				
		try {
			//InputStream을 얻는다.
			instream = con.getInputStream();
			// 입력 받을 InputStreamReader 인스턴스를 생성한다.
			instrread = new InputStreamReader(instream , "utf-8");;
			// InputStreamReader를 버퍼객체를 연결한다.
			buffread = new BufferedReader(instrread);
			
			// data에 buffread의 데이터를 읽어들여 담는다
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 문자열 name 변수를 선언하고 값은 "Name" 을 담는다
		String name = "Name";
		// 문자열 value 변수를 선언하고 값은 "ABC" 를 담는다
		String value = "ABC";
		
		// 쿠키를 생성하고 name, value값을 받는다
		HttpCookie hc = new HttpCookie(name, value);
		
		// 생성한 쿠키에 long형 초단위 최대값을 설정한다. 
		hc.setMaxAge(Integer.valueOf(data));
		
		// 콘솔에서 값을 출력한다..
		System.out.println("Maximum age of the cookie is: "+ hc.getMaxAge());		
	}
	
}
