package one.dao.face;

import java.util.List;


import one.dto.DayClass;
import one.dto.Question;
import one.util.Paging;


public interface QuestionDao {

	
	/**
	  * 질문 조회 - 질문 번호를 rnum을 통해 같이 조회한다
	 * 
	 * @param quesionList - 질문이 조회될 코멘트 
	 * @return List - 조회된 질문 리스트
	 */
	public List selectQuestion(DayClass questionList);
	
	/**
	  * 질문 INSERT
	 * 
	 * @param Question - 삽입될 질문
	 */
	public void insertQuestion(Question question);

	/**
	  * 질문 삭제하기
	 * 
	 * @param Question - 삭제할 질문
	 */
	public void deleteQuestion(Question question);

	/**
	  * 질문 카운트 - 질문 존재 여부 확인
	 * 
	 * @param Question - 존재 여부 체크 대상 질문
	 * @return int - 질문 갯수
	 */
	public int countQuestion(Question question);
	
}
