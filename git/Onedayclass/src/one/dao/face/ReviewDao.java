package one.dao.face;

import java.util.List;


import one.dto.DayClass;
import one.dto.Review;

public interface ReviewDao {

		/**
		  *  리뷰 조회 - 리뷰 번호를 rnum을 통해 같이 조회한다
		 * 
		 * @param reviewList - 댓글이 조회될 코멘트 
		 * @return List - 조회된 리뷰 리스트
		 */
		public List selectReview(DayClass reviewList);
		
		/**
		  * 리뷰 INSERT
		 * 
		 * @param review - 삽입될 리뷰
		 */
		public void insertReview(Review review);

		/**
		  * 리뷰 삭제하기
		 * 
		 * @param review - 삭제할 리뷰
		 */
		public void deleteReview(Review review);

		/**
		   * 리뷰 카운트 - 리뷰 존재 여부 확인
		 * 
		 * @param review - 존재 여부 체크 대상 리뷰
		 * @return int - 리뷰 갯수
		 */
		public int countReview(Review review);

}
	


