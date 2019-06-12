package one.dao.face;

import java.util.List;

import one.dto.Board;
import one.dto.Bulletin_Comment;

public interface CommentDao {

	List selectComment(Board viewBoard);

	void insertComment(Bulletin_Comment comment);

	void deleteComment(Bulletin_Comment comment);

	int countComment(Bulletin_Comment comment);

}
