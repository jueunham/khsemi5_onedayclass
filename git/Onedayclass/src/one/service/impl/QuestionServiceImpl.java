package one.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dao.face.QuestionDao;
import one.dao.impl.QuestionDaoImpl;
import one.dto.DayClass;
import one.dto.Question;
import one.service.face.QuestionService;
import one.util.Paging;

public class QuestionServiceImpl implements QuestionService{
	
	private QuestionDao questionDao = new QuestionDaoImpl();
	
	@Override
	public Question getQuestion(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String classNum = (String) req.getParameter("classNum");
		String userNum = (String) req.getParameter("userNum");
		String content = (String) req.getParameter("content");
		
		Question question = new Question();
		
		question.setClassNum(Integer.parseInt(classNum));
		question.setUserNum(Integer.parseInt(userNum));
		question.setContent(content);
		
		
		return question;
	}

	@Override
	public void insertQuestion(Question question) {
		questionDao.insertQuestion(question);
		
	}

	@Override
	public List getQuestionList(DayClass questionList) {
		return questionDao.selectQuestion(questionList);
				
	}

	@Override
	public boolean deleteQuestion(Question question) {
		questionDao.deleteQuestion(question);
		
		if( questionDao.countQuestion(question) > 0 ) {
			return false;
		} else {
			return true;
		}
	}


	
}
