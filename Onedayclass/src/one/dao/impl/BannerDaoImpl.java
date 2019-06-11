package one.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import one.dao.face.BannerDao;
import one.dbutil.DBConn;
import one.dto.Banner;
import one.dto.Board;

public class BannerDaoImpl implements BannerDao{
	
	// DB관련 객체
	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
		public List selectAll() {
		// 테이블 전체  조회쿼리
			String sql = "";
			sql += "SELECT bannernum,classnum,usernum";
			sql += " FROM banner";
		
			List list1 = new ArrayList();
			
			try {
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				while( rs.next() ) {
					Banner banner = new Banner();
					
					banner.setBannerNum( rs.getInt("bannernum") );
					banner.setClassNum( rs.getInt("classnum") );
					banner.setBannerNum( rs.getInt("usernum") );
					
					list1.add(banner);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list1;			
		}

}
