package one.controller.question;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.Comment;
import one.dto.Question;
import one.service.face.QuestionService;
import one.service.impl.QuestionServiceImpl;




@WebServlet("/question/insert")
public class QuestionInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QuestionService questionService = new QuestionServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Question question = questionService.getQuestion(req);
				
		resp.sendRedirect("/classlist?classNum="+question.getClassNum());
		
		
	}
	
}
