/*
 * 운영체제 명령어 삽입
 * 참조: 없음. 스프링 MVC 기반  샘플
 */
package sample.cwe78.spring;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CWE78_oscmdi_spring_basic_bad01 {
	
	@RequestMapping("/batch")
	public ModelAndView executeBatch(String batchOption) {
		
		String cmd = "CMD.exe -C db_batch.bat -opt " + batchOption;
		
		Process process = null;
		BufferedReader reader = null;
		String line = null;
		StringBuilder buffer = new StringBuilder();
		String errorMessage = "";
		
		try {
			// POTENTAIL FLAW
			process = Runtime.getRuntime().exec(cmd);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			while ((line = reader.readLine()) != null) {
				buffer.append(line + System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} finally {
			if (process != null) {
				process.destroy();
			}
		}
		
		ModelAndView modelAndView = new ModelAndView();
		
		if (errorMessage.isEmpty()) {
			modelAndView.setViewName("success");
			modelAndView.addObject(buffer.toString());
		} else {
			modelAndView.setViewName("fail");
			modelAndView.addObject(errorMessage);
		}
		return modelAndView;
	}
	
	@RequestMapping("/batch2")
	public ModelAndView executeBatch2(Map<String,String> paramMap) {
		
		String cmd = "CMD.exe -C db_batch.bat -opt " + paramMap.get("option");
		
		Process process = null;
		BufferedReader reader = null;
		String line = null;
		StringBuilder buffer = new StringBuilder();
		String errorMessage = "";
		
		try {
			// POTENTAIL FLAW
			process = Runtime.getRuntime().exec(cmd);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			while ((line = reader.readLine()) != null) {
				buffer.append(line + System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} finally {
			if (process != null) {
				process.destroy();
			}
		}
		
		ModelAndView modelAndView = new ModelAndView();
		
		if (errorMessage.isEmpty()) {
			modelAndView.setViewName("success");
			modelAndView.addObject(buffer.toString());
		} else {
			modelAndView.setViewName("fail");
			modelAndView.addObject(errorMessage);
		}
		return modelAndView;
	}
}
