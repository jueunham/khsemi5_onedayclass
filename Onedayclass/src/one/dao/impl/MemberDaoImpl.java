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
						member.setUserphone( rs.getInt("userphone") );
						member.setUserlevel( rs.getString("userlevel") );
						
						list.add(member);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				return list;
				
			}
			
		}

