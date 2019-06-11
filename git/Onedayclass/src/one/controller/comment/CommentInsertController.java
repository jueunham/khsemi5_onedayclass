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



@WebServlet("/comment/insert")
public class CommentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommentService commentService = new CommentServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Comment comment = commentService.getComment(req);
		
		commentService.insertComment(comment);
		
		resp.sendRedirect("/classlist?classNum="+comment.getClassNum());
	}
	
	
}
