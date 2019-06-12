package one.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dao.face.MemberDao;
import one.dbutil.DBConn;
import one.dto.ClassFile;
import one.dto.Member;
import one.dto.MemberFile;

public class MemberDaoImpl implements MemberDao {

	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int selectCntMemberByUseridAndUserpw(Member member) {

		if( member.getUserid() == null || member.getUserpw() == null || member.getUserlevel() == null ) {
			return -1;
			
		} 

		//쿼리 작성
		String sql = "";
		sql += "SELECT COUNT(*) FROM member";
		sql += " WHERE 1=1";
		sql += " AND userid = ?";
		sql += " AND userpw = ?";
		sql += " AND userlevel = ?";
		
		int cnt = -1;
		
		try {
			//DB
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
			ps.setString(2, member.getUserpw());
			ps.setString(3, member.getUserlevel());
			
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
//		sql += " WHERE 1=1";
//		sql += " AND userid = ?";
		sql += " WHERE userid=?";
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUserid());
		
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				member.setUserid( rs.getString("userid") );
				member.setUserpw( rs.getString("userpw") );
				member.setUsernum( rs.getInt("usernum") );
				member.setUsername( rs.getString("username") );
				member.setUserphone( rs.getString("userphone") );
				member.setUserlevel( rs.getString("userlevel") );
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
		sql += "INSERT INTO member ( userNum, userName, userid, userPw, userPhone, userLevel)";
		sql += " VALUES( member_seq.nextval, ?, ?, ?, ?, ? )";
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getUsername());
			ps.setString(2, member.getUserid());
			ps.setString(3, member.getUserpw());
			ps.setString(4, member.getUserphone());
			ps.setString(5, member.getUserlevel());
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
	public void updateinfo(Member member) {
		
			//쿼리작성
			String sql = "";
			sql += "UPDATE member";
			sql += " SET userPhone = ? ";
			sql += " WHERE userid = ?";
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setString(1, member.getUserphone());
				ps.setString(2, member.getUserid());
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

	@Override
	public void insertFile(MemberFile memberFile) {
		String sql = "";
		sql += "INSERT INTO memberfile(fileno,userid,originname,storedname,filesize) ";
		sql += " VALUES (memfile_seq.nextval, ?, ?, ?, ?)";
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, memberFile.getUserid());
			ps.setString(2, memberFile.getOriginName());
			ps.setString(3, memberFile.getStoredName());
			ps.setLong(4, memberFile.getFilesize());

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

	@Override
	public MemberFile selectFile(Member meminfo) {
		String sql = "";
		sql += "SELECT * FROM memberFile";
		sql += " WHERE userid = ?";
		
		MemberFile memberFile = new MemberFile();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, meminfo.getUserid());

			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				memberFile.setFileno( rs.getInt("fileno") );
				memberFile.setUserid( rs.getString("userid") );
				memberFile.setOriginName( rs.getString("originname") );
				memberFile.setStoredName( rs.getString("storedname") );
				memberFile.setFilesize( rs.getLong("filesize") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(ps!=null)	ps.close();
				if(rs!=null)	rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberFile;
	}


}
