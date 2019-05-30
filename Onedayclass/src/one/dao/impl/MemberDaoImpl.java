package one.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import one.dao.face.MemberDao;
import one.dbutil.DBConn;
import one.dto.Member;

public class MemberDaoImpl implements MemberDao {

	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int selectCntMemberByUseridAndUserpw(Member member) {

		if( member.getUserid() == null || member.getUserpw() == null ) {
			return -1;
			
		} 

		//쿼리 작성
		String sql = "";
		sql += "SELECT COUNT(*) FROM member";
		sql += " WHERE 1=1";
		sql += " AND userid = ?";
		sql += " AND userpw = ?";
		
		int cnt = -1;
		try {
			//DB
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getUserpw());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				cnt = rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
		
	}

	@Override
	public Member selectMemberByUserid(Member member) {
		
		if( member.getUserid() == null ) {
			return null;
		}

		//쿼리 작성
		String sql = "";
		sql += "SELECT * FROM member";
		sql += " WHERE 1=1";
		sql += " AND userid = ?";
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
		
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				member.setUserid( rs.getString("userid") );

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return member;
		
	}

	@Override
	public void insert(Member member) {
		
		//쿼리작성
		String sql = "";
		sql += "INSERT INTO member ( userName, userid, userPw, userPhone)";
		sql += " VALUES( ?, ?, ?, ? )";
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, member.getUserNum());
			ps.setString(2, member.getUserName());
			ps.setString(3, member.getUserid());
			ps.setString(4, member.getUserpw());
			ps.setInt(5, member.getUserPhone());
			ps.setString(6, member.getUserLevel());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
