package one.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import one.dao.face.CommentDao;
import one.dbutil.DBConn;
import one.dto.Board;
import one.dto.Bulletin_Comment;

public class CommentDaoImpl implements CommentDao{
	
	  // DB 연결 객체
	  private Connection conn = DBConn.getConnection();
	  
	   // JDBC 객체
	   private PreparedStatement ps;
	   private ResultSet rs;

	@Override
	public List selectComment(Board viewBoard) {
		 
		String sql
	      = "SELECT * FROM ("
	            + "SELECT rownum rnum, B.* FROM ("
	            + "   SELECT"
	            + "      commentno,"
	            + "      content,"
	            + "      commentdate,"
	            + "      userid,"
	            + "      boardno"
	            + "   FROM Bulletin_comment"
	            + "   WHERE boardno = ?"
	            + "   ORDER BY commentdate DESC"
	            + "   ) B"
	            + ") ORDER BY rnum";

	      List commentList = new ArrayList();
	      try {
	         ps = conn.prepareStatement(sql);

	         ps.setInt(1, viewBoard.getBoardno() );

	         // ResultSet 반환
	         rs = ps.executeQuery();

	         while( rs.next() ) {
	            Bulletin_Comment comment = new Bulletin_Comment();

	            comment.setCommentno(rs.getInt("commentno"));
	            comment.setContent(rs.getString("content"));
	            comment.setCommentdate(rs.getString("commentdate"));
	            comment.setUserid(rs.getString("userid"));
	            comment.setBoardno(rs.getInt("boardno"));
	         

	            commentList.add(comment);
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(rs!=null)   rs.close();
	            if(ps!=null)   ps.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }

	      }

	      return commentList;

	}

	@Override
	public void insertComment(Bulletin_Comment comment) {
	      
		String sql
	      = "INSERT INTO Bulletin_Comment ("
	            + "      commentno,"
	            + "      content,"
	            + "      userid,"
	            + "      boardno )"
	            + "   VALUES ("
	            + "      Bulletin_Comment_seq.nextval,"
	            + "      ?,"
	            + "      ?, "
	            + "      ? )";

	      try {
	         ps = conn.prepareStatement(sql);

	         ps.setString(1, comment.getContent());
	         ps.setString(2, comment.getUserid());
	         ps.setInt(3, comment.getBoardno());

	         ps.executeUpdate();

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(ps!=null)   ps.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	}

	@Override
	public void deleteComment(Bulletin_Comment comment) {
		String sql
	      = "DELETE Bulletin_Comment"
	            + "   WHERE commentno = ?";

	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setInt(1, comment.getCommentno());
	         
	         ps.executeUpdate();

	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if(ps!=null)   ps.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	   }

	@Override
	public int countComment(Bulletin_Comment comment) {
		String sql = "SELECT COUNT(*) FROM Bulletin_Comment WHERE commentno=?";
	      
	      int cnt = 0;
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setInt(1, comment.getCommentno());
	         rs = ps.executeQuery();
	         rs.next();
	         cnt = rs.getInt(1);
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            rs.close();
	            ps.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      
	      return cnt;

	}
}
