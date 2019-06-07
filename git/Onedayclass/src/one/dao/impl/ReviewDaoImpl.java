package one.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import one.dao.face.ReviewDao;
import one.dbutil.DBConn;
import one.dto.DayClass;
import one.dto.Review;

public class ReviewDaoImpl implements ReviewDao{
	
	// DB 연결 객체
	private Connection conn = DBConn.getConnection();

	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	@Override
	public List selectReview(DayClass reviewList) {
		
		String sql
		= "SELECT * FROM ("
				+ "SELECT rownum rnum, R.* FROM ("
				+ "	SELECT"
				+ "		reviewNum,"
				+ "		classNum,"
				+ "		userNum,"
				+ "		content"
				+ "		reviewDate"	
				+ "		FROM review"
				+ "		WHERE classNum = ?"
				+ "	) R"
				+ ") ORDER BY rnum";

		List revList = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, reviewList.getClassnum());

			// ResultSet 반환
			rs = ps.executeQuery();

			while( rs.next() ) {
				Review review = new Review();

				review.setRnum(rs.getInt("rnum"));
				review.setReviewNum(rs.getInt("reviewNum"));
				review.setClassNum(rs.getInt("classNum"));
				review.setUserNum(rs.getInt("userNum"));
				review.setContent(rs.getString("content"));
				review.setReviewDate(rs.getDate("reviewDate"));
				

				revList.add(review);
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

		return revList;
		
	}

		
	
	@Override
	public void insertReview(Review review) {
		String sql
		= "INSERT INTO comm ("
				+ "		reviewNum,"
				+ "		classNum,"
				+ "		userNum,"
				+ "		reviewDate,"
				+ "		content )"
				+ "	VALUES ("
				+ "		review_seq.nextval,"
				+ "		?,"
				+ "		?,"
				+ "		? )";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, review.getClassNum());
			ps.setInt(2, review.getUserNum());
			ps.setString(3, review.getContent());
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
	public void deleteReview(Review review) {
		String sql
		= "DELETE review"
				+ "	WHERE reviewNum = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, review.getReviewNum());
			
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
	public int countReview(Review review) {
		
		String sql = "SELECT COUNT(*) FROM review WHERE reviewNum=?";
		
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, review.getReviewNum());
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
