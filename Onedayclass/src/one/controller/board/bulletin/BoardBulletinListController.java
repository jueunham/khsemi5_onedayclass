package one.controller.board.bulletin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.service.face.BoardService;
import one.service.impl.BoardServiceImpl;
import one.util.Paging;

@WebServlet("/board/bulletin/list")
public class BoardBulletinListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//BoardService 객체
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터에서 curPage 얻어오기
		Paging paging = boardService.getCurPage(req);
		
		//MODEL로 Paging 객체 넣기
		req.setAttribute("bulletinPaging", paging);
		
		//게시판 목록 조회
		List list = boardService.getbulletinList(paging);
		
		//MODEL로 조회 결과 넣기
		req.setAttribute("bulletinlist", list);
		
		//VIEW지정
		req.getRequestDispatcher("/WEB-INF/views/board/bulletin/list.jsp").forward(req, resp);
		
	}
	
}





