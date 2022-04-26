package sample.cwe89_3;

import java.util.List;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();
	
	public void remove(String title) throws ServiceException {
		try {
			List<ArticleVO> articles = dao.getArticles(title);
			
			for (ArticleVO vo : articles) {
				dao.remove(vo.getId());
			}
		} catch (Exception e) {
			throw new ServiceException("remove error", e);
		}
	}
	
	public void remove2(String title) throws ServiceException {
		try {
			List<ArticleVO> articles = dao.getArticles_2(title);
			
			for (ArticleVO vo : articles) {
				dao.remove(vo.getId());
			}
		} catch (Exception e) {
			throw new ServiceException("remove error", e);
		}
	}
}
