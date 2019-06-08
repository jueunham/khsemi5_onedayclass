package one.dao.impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import one.dao.face.CommentDao;
import one.dbutil.DBConn;
import one.dto.Comment;
import one.dto.DayClass;



public class CommentDaoImpl implements CommentDao {

	// DB 연결 객체
	private Connection conn = DBConn.getConnection();

	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List selectComment(DayClass commentList) {

		String sql
		= "SELECT * FROM ("
				+ "SELECT rownum rnum, C.* FROM ("
				+ "	SELECT"
				+ "		commNum,"
				+ "		classNum,"
				+ "		userNum,"
				+ "		content"
				+ "		FROM comm"
				+ "		WHERE classNum = ?"
				+ "	) C"
				+ ") ORDER BY rnum";

		List commList = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, commentList.getClassnum() );

			// ResultSet 반환
			rs = ps.executeQuery();

			while( rs.next() ) {
				Comment comment = new Comment();

				comment.setRnum(rs.getInt("rnum"));
				comment.setClassNum(rs.getInt("classNum"));
				comment.setCommNum(rs.getInt("commNum"));
				comment.setUserNum(rs.getInt("userNum"));
				comment.setContent(rs.getString("content"));

				commList.add(comment);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return commList;
		
	}
	

	@Override
	public void insertComment(Comment comment) {
		String sql
		= "INSERT INTO comm ("
				+ "		commNum,"
				+ "		classNum,"
				+ "		userNum,"
				+ "		content )"
				+ "	VALUES ("
				+ "		comm_seq.nextval,"
				+ "		?,"
				+ "		?,"
				+ "		? )";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, comment.getClassNum());
			ps.setInt(2, comment.getUserNum());
			ps.setString(3, comment.getContent());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}
		
	
	@Override
	public void deleteComment(Comment comment) {
		String sql
		= "DELETE comm"
				+ "	WHERE commNum = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getCommNum());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
						
	
	@Override
	public int countComment(Comment comment) {
		
		String sql = "SELECT COUNT(*) FROM comm WHERE commNum=?";
		
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comment.getCommNum());
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
