package one.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dto.Comment;
import one.dto.DayClass;

public interface CommentService {
	
	
	
	public Comment getComment(HttpServletRequest req);
	/**
	 * 댓글 전달파라미터 꺼내기
	 */
	
	
	
	public void insertComment(Comment comment);
	/**
	 * 댓글 입력
	 * 
	 * @param comment - 삽입될 댓글
	 */
	
	
	public List getCommentList(DayClass commentList);
	/**
	 * 댓글 리스트
	 * 
	 * @param commentList - 댓글이 조회될 게시글
	 * @return List - 댓글 리스트
	 */
	
	public boolean deleteComment(Comment comment);
	/**
	 * 댓글 삭제
	 *  
	 * @param comment - 삭제할 댓글
	 * @return boolean - 삭제 성공 여부
	 */


	
	
}
