package one.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import one.dao.face.QuestionDao;
import one.dbutil.DBConn;
import one.dto.Comment;
import one.dto.DayClass;
import one.dto.Question;
import one.util.Paging;

public class QuestionDaoImpl implements QuestionDao {
	
	// DB 연결 객체
	private Connection conn = DBConn.getConnection();

	// JDBC 객체
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	@Override
	public List selectQuestion(DayClass questionList) {
		String sql
		= "SELECT * FROM ("
				+ "SELECT rownum rnum, Q.* FROM ("
				+ "	SELECT"
				+ "		quesNum,"
				+ "		classNum,"
				+ "		userNum,"
				+ "		content,"
				+ "		quesDate"
				+ "		FROM question"
				+ "		WHERE classNum = ?"
				+ "	) Q"
				+ ") ORDER BY rnum";

		List quesList = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, questionList.getClassnum());

			// ResultSet 반환
			rs = ps.executeQuery();

			while( rs.next() ) {
				Question question = new Question();

				question.setRnum(rs.getInt("rnum"));
				question.setClassNum(rs.getInt("classNum"));
				question.setQuesNum(rs.getInt("quesNum"));
				question.setUserNum(rs.getInt("userNum"));
				question.setContent(rs.getString("content"));
				question.setQuesDate(rs.getDate("quesDate"));
				quesList.add(question);
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

		return quesList;
		
	
	}

	@Override
	public void insertQuestion(Question question) {
		String sql
		= "INSERT INTO question ("
				+ "		quesNum,"
				+ "		classNum,"
				+ "		userNum,"
				+ "		content,"
				+ "		quesDate )"
				+ "	VALUES ("
				+ "		ques_seq.nextval,"
				+ "		?,"
				+ "		?,"
				+ "		? )";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, question.getClassNum());
			ps.setInt(2, question.getUserNum());
			ps.setString(3, question.getContent());
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
	public void deleteQuestion(Question question) {
		String sql
		= "DELETE question"
				+ "	WHERE quesNum = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, question.getQuesNum());
			
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
	public int countQuestion(Question question) {
		String sql = "SELECT COUNT(*) FROM question WHERE quesNum=?";
		
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, question.getQuesNum());
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
