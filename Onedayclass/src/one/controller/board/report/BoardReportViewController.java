package one.controller.board.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.Board;
import one.service.face.BoardService;
import one.service.impl.BoardServiceImpl;
import one.dto.BoardFile;

@WebServlet("/board/report/view")
public class BoardReportViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// BoardService 객체
	private BoardService boardService = new BoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 게시글 번호 파싱
		Board viewBoard = boardService.getBoardno(req);

		// 게시글 조회
		viewBoard = boardService.view(viewBoard);

		// MODEL로 게시글 전달
		req.setAttribute("viewBoard", viewBoard);
		
		//첨부파일 전달
		BoardFile boardFile = boardService.viewFile(viewBoard);
		req.setAttribute("boardFile", boardFile);

		// VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/board/report/view.jsp").forward(req, resp);

	}
}

