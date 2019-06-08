package one.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dao.face.CommentDao;
import one.dao.impl.CommentDaoImpl;
import one.dto.Comment;
import one.dto.DayClass;
import one.service.face.CommentService;


public class CommentServiceImpl implements CommentService {
	
	private CommentDao commentDao = new CommentDaoImpl();
	
	
	@Override
	public Comment getComment(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String classNum = (String) req.getParameter("classNum");
		String userNum = (String) req.getParameter("userNum");
		String content = (String) req.getParameter("content");
		
		Comment comment = new Comment();
		comment.setClassNum( Integer.parseInt(classNum));
		comment.setUserNum( Integer.parseInt(userNum));
		comment.setContent(content);
		
		return comment;
	}

	
	@Override
	public void insertComment(Comment comment) {
		
		commentDao.insertComment(comment);
	}

	@Override
	public List getCommentList(DayClass commentList) {
		return commentDao.selectComment(commentList);
	}

	@Override
	public boolean deleteComment(Comment comment) {
		commentDao.deleteComment(comment);
		
		if( commentDao.countComment(comment) > 0 ) {
			return false;
		} else {
			return true;
		}
				
	}



}
