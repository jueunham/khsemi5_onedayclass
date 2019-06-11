package one.service.face;

import java.util.List;


import javax.servlet.http.HttpServletRequest;


import one.dto.DayClass;
import one.dto.Question;
import one.util.Paging;


public interface QuestionService {
	

	
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
