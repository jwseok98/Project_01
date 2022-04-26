package sample.dataflow.sqlinjection.spf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import sample.dataflow.sqlinjection.UserDto;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(String userId, String userPassword) throws Exception {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
		        .getRequestAttributes()).getRequest();
		
		if (userService.login(request, userId, userPassword)) {
			return "/main";
		}
		return "/";
	}
	
	@RequestMapping("/viewUser")
	public ModelAndView viewUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userid");
		
		UserDto userDto = userService.getUser(userId);
		
		if (userDto != null) {
			ModelAndView modelAndView = new ModelAndView("view");
			modelAndView.addObject("USER", userDto);
			return modelAndView;
		}
		return new ModelAndView("/");
	}
}
