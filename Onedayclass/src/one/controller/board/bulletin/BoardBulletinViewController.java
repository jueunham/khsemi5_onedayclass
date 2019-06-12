package one.controller.board.bulletin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.Board;
import one.service.face.BoardService;
import one.service.impl.BoardServiceImpl;
import one.dto.BoardFile;
import one.dto.Bulletin_Comment;

@WebServlet("/board/bulletin/view")
public class BoardBulletinViewController extends HttpServlet {
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
		
	     //댓글 리스트 전달
	     Bulletin_Comment comment = new Bulletin_Comment();
	     List<Bulletin_Comment> commentList =boardService.getCommentList(viewBoard);
	     req.setAttribute("commentList", commentList);

		// VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/board/bulletin/view.jsp").forward(req, resp);

	}
}

