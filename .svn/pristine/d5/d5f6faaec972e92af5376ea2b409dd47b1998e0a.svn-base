/*
 * 참조: 없음. 스프링 MVC 기반 샘플 - 크로스사이트스트요청위조
 */
package sample.cwe352.spring;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CWE352_csrf_spring_basic {
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public ModelAndView writeArticle_bad01(String title, String contents) throws Exception { // POTENTAIL FLAW
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view");
		modelAndView.addObject(title);
		
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value="/write2", method={RequestMethod.GET, RequestMethod.POST})
	public String writeArticle_bad02(String title, String contents) throws Exception { // POTENTAIL FLAW
		return title;
	}
	
	@RequestMapping(value="/write3")
	public void writeArticle_bad03(String title, String contents, HttpServletResponse response) throws Exception { // POTENTAIL FLAW
		response.getWriter().println(title);
	}
	
	@RequestMapping(value="/write4", method=RequestMethod.POST) // method = post, GOOD!!
	public ModelAndView writeArticle_good(String title, String contents, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view");
		modelAndView.addObject(title);
		return modelAndView;
	}	
}
