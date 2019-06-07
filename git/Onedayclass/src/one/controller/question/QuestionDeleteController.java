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


@WebServlet("/question/delete")
public class QuestionDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private QuestionService questionService = new QuestionServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Question question = new Question();
		
		String quesNum = (String) req.getParameter("quesNum");
				
		question.setQuesNum(Integer.parseInt(quesNum));
		
		boolean success = questionService.deleteQuestion(question);
		
		resp.getWriter().append("{\"success\":"+success+"}");
		
		
	}
	
}
