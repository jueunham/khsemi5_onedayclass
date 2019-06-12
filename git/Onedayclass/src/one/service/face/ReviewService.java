package one.service.face;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import one.dto.DayClass;
import one.dto.Review;

public interface ReviewService {
	
	
	public DayClass getdayClassNum(HttpServletRequest req);
	
	/**
	 * 상세보기 리뷰 조회
	 * 
	 * @param viewclass - 상세보기할 classNum을 가진 객체
	 * @return class - 상세보기할 게시글 조회 결과
	 */
	
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
	
	
	public List getReviewList(DayClass reviewList);
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
