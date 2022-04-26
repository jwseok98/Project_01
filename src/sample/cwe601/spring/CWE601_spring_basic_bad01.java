/*
 * 신뢰되지 않는 URL 주소로 자동접속 연결 
 * 참조: 없음. 스프링 MVC 기반  샘플
 */
package sample.cwe601.spring;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CWE601_spring_basic_bad01 {
	
	@RequestMapping(value="/redirect1")
	public String redirect1(@RequestParam(value="returnUrl") String returnUrl) {
		// POTENTIAL FLAW
		return "redirect:" + returnUrl;
	}
	
	@RequestMapping(value="/redirect1")
	public String redirect1(Model model) {
		String returnUrl = (String) model.asMap().get("returnUrl");
		
		// POTENTIAL FLAW
		return "redirect:" + returnUrl;
	}
	
	
	@RequestMapping(value="/redirect2")
	public void redirect2(@RequestParam(value="returnUrl") String returnUrl, HttpServletResponse response) {
		try {
			// POTENTIAL FLAW
			response.sendRedirect(returnUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
