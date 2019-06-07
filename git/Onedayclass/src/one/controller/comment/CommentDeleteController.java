package one.controller.comment;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.Comment;
import one.service.face.CommentService;
import one.service.impl.CommentServiceImpl;


/**
 * Servlet implementation class CommentDelete
 */
@WebServlet("/comment/delete")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CommentService commentService = new CommentServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			doPost(req, resp);
		
		}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		Comment comment = new Comment();
		
		String commentNum = (String) req.getParameter("commentNum");
				
		comment.setCommNum(Integer.parseInt(commentNum));
		
		boolean success = commentService.deleteComment(comment);
		
		resp.getWriter().append("{\"success\":"+success+"}");
		
		
		
		}
	
	
}
