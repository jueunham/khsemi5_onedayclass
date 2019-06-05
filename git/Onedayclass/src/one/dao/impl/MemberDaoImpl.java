package one.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import one.dao.face.MemberDao;
import one.dbutil.DBConn;
import one.dto.Member;

public class MemberDaoImpl implements MemberDao {
	
	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 


	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List selectAll() {
		//파일업로드 기록 조회쿼리
				String sql = "";
				sql+="SELECT usernum,username,userid,userpw,userphone,userlevel";
				sql+=" FROM member";
							
				List list = new ArrayList();
				try {
					ps = conn.prepareStatement(sql);
					
					rs = ps.executeQuery();
					
					while( rs.next() ) {
						Member member = new Member();
						
						member.setUsernum( rs.getInt("usernum") );
						member.setUsername( rs.getString("username") );
						member.setUserid( rs.getString("userid") );
						member.setUserpw( rs.getString("userpw") );
						member.setUserphone( rs.getString("userphone") );
						member.setUserlevel( rs.getString("userlevel") );
						
						list.add(member);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				return list;
				
			}
			
		
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
			ps.setInt(1, member.getUsernum());
			ps.setString(2, member.getUsername());
			ps.setString(3, member.getUserid());
			ps.setString(4, member.getUserpw());
			ps.setString(5, member.getUserphone());
			ps.setString(6, member.getUserlevel());
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

