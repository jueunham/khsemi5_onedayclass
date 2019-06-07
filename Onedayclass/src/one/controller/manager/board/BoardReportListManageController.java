package one.controller.manager.board;

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

@WebServlet("/admin/board/report/list")
public class BoardReportListManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// BoardService 객체
	private BoardService boardService = new BoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//게시판 목록조회
	List list  = boardService.getreportList();
			
	// MODEL로 조회 결과 넣기
	req.setAttribute("reportlist", list);
	
	// view 지정
	req.getRequestDispatcher("/WEB-INF/views/manager/boardManage/reportManage.jsp").forward(req, resp);
	
	}
}
