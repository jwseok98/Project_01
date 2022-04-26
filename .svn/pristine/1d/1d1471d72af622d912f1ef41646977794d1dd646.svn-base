/*
 * 참조: 없음. 스프링 MVC 기반 샘플 - HTTP 응답 분할
 */
package sample.cwe113.spring;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CWE113_httprespsplit_spring_basic_bad01 {
	
	@RequestMapping(value="lastlogin")
	public void getLastLoginInfo(String lastLogin, HttpServletResponse response) {
		
		// 쿠키는 Set-Cookie 응답헤더로 전달되므로 개행문자열 포함 여부 검증이 필요
		Cookie c = new Cookie("LASTLOGIN", lastLogin);
		c.setMaxAge(1000);
		c.setSecure(true);
		
		// POTENTIAL FLAW
		response.addCookie(c);
		response.setContentType("text/html");
	}
}
