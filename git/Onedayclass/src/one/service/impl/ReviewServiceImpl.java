package one.service.impl;

import java.io.UnsupportedEncodingException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dao.face.ReviewDao;
import one.dao.impl.ReviewDaoImpl;
import one.dto.DayClass;
import one.dto.Review;
import one.service.face.ReviewService;


public class ReviewServiceImpl implements ReviewService{
	
	private ReviewDao reviewDao = new ReviewDaoImpl();
	
	@Override
	public Review getReview(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String classNum = (String) req.getParameter("classNum");
		String userNum = (String) req.getParameter("userNum");
		String content = (String) req.getParameter("content");
		
		Review review = new Review();
		review.setClassNum( Integer.parseInt(classNum));
		review.setUserNum( Integer.parseInt(userNum));
		review.setContent(content);
		
		return review;
	}

	@Override
	public void insertReview(Review review) {
		reviewDao.insertReview(review);
		
	}

	@Override
	public List getReviewList(DayClass reviewList) {
		return reviewDao.selectReview(reviewList);
				
	}

	@Override
	public boolean deleteReview(Review review) {
		reviewDao.deleteReview(review);
		
		if( reviewDao.countReview(review) > 0 ) {
			return false;
		} else {
			return true;
		}
			
		
				
	}

	@Override
	public DayClass getdayClassNum(HttpServletRequest req) {
		
		String param = req.getParameter("classNum");
		int classNum = 0;
		if( param!=null && !"".equals(param) ) {
			classNum = Integer.parseInt(param);
		}
				
	
		DayClass dayclass = new DayClass();
		dayclass.setClassNum(classNum);
				
		return dayclass;
	}

}
