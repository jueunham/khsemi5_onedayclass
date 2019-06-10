package one.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import one.dao.face.MypageDao;
import one.dbutil.DBConn;
import one.dto.Member;
import one.dto.UserInterList;


public class MypageDaoImpl implements MypageDao{
	
	private Connection conn = DBConn.getConnection(); 
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Map<String, Object>> selectClass() {

		String sql = "";
		sql += "SELECT c.className, res.reservNum, pay.paymentDate"; 
		sql += " FROM reservation res"; 
		sql += "	JOIN dayclass c";
		sql += "		ON ( res.classNum = c.classNum )";
		sql += "	JOIN payment pay";
		sql += "		ON ( res.reservNum = pay.reservNum )";
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("className", rs.getString("classname"));
				map.put("paymentDate", rs.getDate("paymentDate"));
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	@Override
	public Member selectUserNum(Member member) {

		String sql = "";
		sql += "SELECT * FROM member";
		sql += " WHERE usernum = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, member.getUsernum());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				member.setUsernum(rs.getInt("usernum"));
				member.setUserid(rs.getString("userid"));
				member.setUsername(rs.getString("username"));
				member.setUserpw(rs.getString("userpw"));
				member.setUserphone(rs.getString("userphone"));
				member.setUserlevel(rs.getString("userlevel"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
					
		return member;
	}
	
	@Override
	public void updateInfoPhone(Member member) {

		String sql = "";
		sql += "UPDATE member";
		sql += " SET userPhone = ?";
		sql += " WHERE userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, member.getUserphone());
			ps.setString(2, member.getUserid());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void updateInfoInter(UserInterList userinter) {
		
		String sql = "";
		sql += "UPDATE userinterlist";
		sql += " SET interlistNum = ?";
		sql += " WHERE usernum = ? AND listNum = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userinter.getInterListNum());
			ps.setInt(2, userinter.getUserNum());
			ps.setInt(3, userinter.getListNum());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public List<Map<String, Object>> selectWishList() {

		String sql = "";
		sql += "SELECT w.wishNum, w.userNum, c.className, c.classPrice";
		sql += " FROM wishlist w, dayclass c";
		sql += " WHERE w.userNum = c.userNum";
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("wishNum", rs.getInt("wishNum"));
				map.put("userNum", rs.getInt("userNum"));
				map.put("className", rs.getString("classname"));
				map.put("classPrice", rs.getInt("classprice"));
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<Map<String, Object>> selectRevQue() {
		
		String sql = "";
		sql += "SELECT c.className, r.reviewDate, q.quesDate";
		sql += " FROM dayclass c, review r, question q"; 
		sql += " WHERE c.classNum = r.classNum AND c.classNum = q.classNum";
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("className", rs.getString("classname"));
				map.put("reviewDate", rs.getDate("reviewDate")); 
				map.put("quesDate", rs.getDate("quesDate"));
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
		
	}

}
