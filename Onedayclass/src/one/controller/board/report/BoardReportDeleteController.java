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

@WebServlet("/board/report/delete")
public class BoardReportDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// BoardService 객체
		private BoardService boardService = new BoardServiceImpl();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			Board board = boardService.getBoardno(req);

			boardService.delete(board);

			// 목록으로 리다이렉트
			resp.sendRedirect("/board/report/list");
		}
}

