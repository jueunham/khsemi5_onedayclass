package one.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.service.face.BoardService;
import one.service.impl.BoardServiceImpl;

@WebServlet("/admin/board")
public class BoardManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//BoardService 객체
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//게시판 목록조회
		List list  = boardService.getList();
		
		//MODEL로 조회 결과 넣기
		req.setAttribute("boardlist", list);
	
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/manager/boardManage/boardManage.jsp").forward(req, resp);
	 }
}
