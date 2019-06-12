package one.controller.board.bulletin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.Bulletin_Comment;
import one.service.face.BoardService;
import one.service.impl.BoardServiceImpl;

@WebServlet("/board/bulletin/comment/insert")
public class BoardBulletinCommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private BoardService boardService = new BoardServiceImpl();

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
       doPost(req, resp);
    
    }

    
    @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
    	Bulletin_Comment comment = boardService.getComment(req);
          
          boardService.insertComment(comment);
          
          resp.sendRedirect("/board/bulletin/view?boardno="+comment.getBoardno());

	}
}
