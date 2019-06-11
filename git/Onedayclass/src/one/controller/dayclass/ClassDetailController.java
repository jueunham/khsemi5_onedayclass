package one.controller.dayclass;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.DayClass;
import one.dto.Question;
import one.dto.Review;
import one.service.face.QuestionService;
import one.service.face.ReviewService;
import one.service.impl.QuestionServiceImpl;
import one.service.impl.ReviewServiceImpl;




@WebServlet("/classdetail")
public class ClassDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReviewService reviewService = new ReviewServiceImpl();
	private QuestionService questionService = new QuestionServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DayClass viewdayclass = reviewService.getdayClassNum(req);

		//리뷰 리스트 전달
		Review review = new Review();
		List<Review> reviewList = reviewService.getReviewList(viewdayclass);
		req.setAttribute("reviewList", reviewList);
		
		
		//질문 리스트 전달
		Question question = new Question();
		List<Question> questionList = questionService.getQuestionList(viewdayclass);
				
		req.setAttribute("questionList", questionList);
				
				
		req.getRequestDispatcher("/WEB-INF/views/class/detail.jsp").forward(req, resp);
		
	}
	 
	
	
	
}
