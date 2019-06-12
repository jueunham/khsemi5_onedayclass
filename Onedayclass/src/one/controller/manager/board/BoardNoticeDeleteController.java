package one.controller.manager.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.Board;
import one.service.face.BoardService;
import one.service.impl.BoardServiceImpl;


@WebServlet("/admin/board/notice/delete")
public class BoardNoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Board board = boardService.getBoardno(req);
		
		boardService.delete(board);
		
		
		resp.sendRedirect("/admin/board/notice/list");
	}
}
