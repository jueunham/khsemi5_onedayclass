package one.controller.review;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.Review;
import one.service.face.ReviewService;
import one.service.impl.ReviewServiceImpl;




@WebServlet("/review/delete")
public class ReviewDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReviewService reviewService = new ReviewServiceImpl();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Review review = new Review();
		
		String reviewNum = (String) req.getParameter("reviewNum");
		
		review.setReviewNum(Integer.parseInt(reviewNum));
		
		boolean success = reviewService.deleteReview(review);
				
		resp.getWriter().append("{\"success\":"+success+"}");
		
		
		
		
	}
	
	
}
