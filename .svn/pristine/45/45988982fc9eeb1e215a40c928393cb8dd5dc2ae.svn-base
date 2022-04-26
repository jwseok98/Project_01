package sample.cwe79.spring;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sample.cwe79.BoardArticleVo;

@Controller
public class CWE79_xss_spring_basic_bad01 {
	
	@RequestMapping("/board/list")
	@ResponseBody
	public String getBoardArticleByName(String boardName) {
		// RequestMapping, ResponseBody 애노테이션이 설정된 메서드에서 입력값이 반환되는 경우 탐지 해야함.
		
		// POTENTAIL FLAW: 1
		return "thank " + boardName;
	}
	
	@RequestMapping("/board/list")
	public void getBoardArticleByName(String boardName, HttpServletResponse response) throws IOException {
		// RequestMapping 애노테이션이 설정된 메서드에서 입력값이 HttpServletResponse.println 함수의 매개변수로 전달되면 탐지 해야함.
		
		// POTENTAIL FLAW: 1
		response.getWriter().println("thank " + boardName);
	}
	
	// Bad Method
	@RequestMapping("/board/list")
	public ModelAndView getBoardArticles(String boardId) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/board_list.jsp");
		
		// POTENTAIL FLAW: 1
		mav.addObject(boardId);
		
		// POTENTAIL FLAW: 2
		mav.addObject("boardId", boardId);
		
		return mav;
	}
	
	@RequestMapping("/board/add")
	public ModelAndView addBoardArticle(String boardId, BoardArticleVo vo) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/board_list.jsp");
		
		// POTENTAIL FLAW: 1
		mav.addObject("boardId", boardId);
		
		// POTENTAIL FLAW: 2
		mav.addObject("title", vo.getTitle());
		
		return mav;
	}
	
	@RequestMapping("/board/view")
	public ModelAndView viewBoardArticle(String boardId, int seqId) {
		
		BoardArticleVo vo = getVo(seqId);
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/board_view.jsp");
		
		// POTENTAIL FLAW: 1
		mav.addObject("boardId", boardId);
		
		// POTENTAIL FLAW: 2
		mav.addObject("vo", vo);
		
		return mav;
	}
	
	private BoardArticleVo getVo(int seqId) {
		return new BoardArticleVo();
	}
}