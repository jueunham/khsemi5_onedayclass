package one.service.face;

import java.util.List;


import javax.servlet.http.HttpServletRequest;


import one.dto.DayClass;
import one.dto.Question;
import one.util.Paging;


public interface QuestionService {
	
	
	public DayClass getdayClassNum(HttpServletRequest req);
	
	/**
	 * 상세보기 리뷰 조회
	 * 
	 * @param viewclass - 상세보기할 classNum을 가진 객체
	 * @return question - 상세보기할 게시글 조회 결과
	 */
	

	
	public Question getQuestion(HttpServletRequest req);
	/**
	  * 질문 전달파라미터 꺼내기
	 */
	
	
	
	public void insertQuestion(Question question);
	/**
	 * 질문 입력
	 * 
	 * @param comment - 삽입될 질문
	 */
	
	
	public List getQuestionList(DayClass questionList);
	/**
	 *질문 리스트
	 * 
	 * @param questionList - 질문이 조회될 게시글
	 * @return List - 질문 리스트
	 */
	
	public boolean deleteQuestion(Question question);
	/**
	 * 질문 삭제
	 *  
	 * @param comment - 삭제할 질문
	 * @return boolean - 삭제 성공 여부
	 */
	
}
