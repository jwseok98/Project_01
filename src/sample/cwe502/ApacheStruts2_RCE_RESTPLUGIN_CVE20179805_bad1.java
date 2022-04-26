/*
 * 참조: Apache Struts2 원격코드 실행 취약점 (CVE-2017-9805)
 * Rest 플러그인의 XStream 
 */
package sample.cwe502;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * ContentTypeHandler 구현체
 * @author gyh
 *
 */
public class ApacheStruts2_RCE_RESTPLUGIN_CVE20179805_bad1 implements org.apache.struts2.rest.handler.ContentTypeHandler {
	
	@Override
	public void toObject(Reader in, Object target) throws IOException {
		/* POTENTIAL FLAW: toObject 메소드가 1개만 있으면 취약점이 존재하는 REST 플러그인 버전 */
		return;
	}
	
	@Override
	public String fromObject(Object obj, String resultCode, Writer stream) throws IOException {
		/* POTENTIAL FLAW: toObject 메소드가 1개만 있으면 취약점이 존재하는 REST 플러그인 버전 */
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExtension() {
		// TODO Auto-generated method stub
		return null;
	}
}