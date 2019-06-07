package one.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dto.DayClass;
import one.dto.Review;

public interface ReviewService {
	
	public Review getReview(HttpServletRequest req);
	/**
	  * 리뷰 전달파라미터 꺼내기
	 */
	
	
	
	public void insertReview(Review review);
	/**
	  * 리뷰 입력
	 * 
	 * @param comment - 삽입될 리뷰
	 */
	
	
	public List getReviewList(DayClass ReviewList);
	/**
	  * 리뷰 리스트
	 * 
	 * @param reviewList - 리뷰가 조회될 게시글
	 * @return List - 리뷰 리스트
	 */
	
	public boolean deleteReview(Review review);
	/**
	  *  리뷰 삭제
	 *  
	 * @param comment - 삭제할 리뷰
	 * @return boolean - 삭제 성공 여부
	 */
}
