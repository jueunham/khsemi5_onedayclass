package one.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import one.dao.face.ClassDao;
import one.dbutil.DBConn;
import one.dto.ClassFile;
import one.dto.DayClass;
import one.util.Paging;


public class ClassDaoImpl implements ClassDao {

	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List selectAll(Paging paging) {
		String sql = "";
		sql+="select * from (";
		sql+=" select rownum rnum , D.*from (" ;
		sql+=" SELECT classNum, className, classContent, classDay, classTime,";
		sql+=" classPlace, classPrice, classRunningTime from dayclass";
		sql+=" ORDER BY classNum DESC" ;
		sql+=" ) D " ;
		sql+=" ORDER BY rnum " ;
		sql+=" ) dayClass" ;
		sql+=" where rnum between ? and ?" ;
	
		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt( 1 , paging.getStartNo() ) ;
			ps.setInt( 2 , paging.getEndNo() ) ;
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				DayClass dayclass = new DayClass();
				
				dayclass.setClassNum(rs.getInt("classNum"));
				dayclass.setClassName(rs.getString("className"));
				dayclass.setClassContent(rs.getString("classContent"));
				dayclass.setClassDay(rs.getDate("classDay"));
				dayclass.setClassTime(rs.getDate("classTime"));
				dayclass.setClassPlace(rs.getString("classPlace"));
				dayclass.setClassPrice(rs.getInt("classPrice"));
				dayclass.setClassRunningTime(rs.getInt("classRunningTime"));
		
				list.add(dayclass);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return list;
	}

	@Override
	public int selectCntAll() {
		//파일업로드 기록 조회쿼리
		String sql = "";
		sql+="";
		sql+="select count(*)";
		sql+=" from dayclass";
	
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {

				totalCount = rs.getInt( 1 ) ;
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return totalCount ;
	}

	@Override
	public DayClass selectDayClassByClassNum(DayClass dayclass) {
		String sql = "";
		sql+="";
		sql+=" SELECT classNum, className, classContent, classDay, classTime,";
		sql+=" classPlace, classPrice, classRunningTime from dayclass";
		sql+=" where classNum = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt( 1 , dayclass.getClassNum() );
			rs = ps.executeQuery();	
			
			while( rs.next() ) {
				
				dayclass.setClassNum(rs.getInt("classNum"));
				dayclass.setClassName(rs.getString("className"));
				dayclass.setClassContent(rs.getString("classContent"));
				dayclass.setClassDay(rs.getDate("classDay"));
				dayclass.setClassTime(rs.getDate("classTime"));
				dayclass.setClassPlace(rs.getString("classPlace"));
				dayclass.setClassPrice(rs.getInt("classPrice"));
				dayclass.setClassRunningTime(rs.getInt("classRunningTime"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dayclass ;
	}

	

	

	
	
	
	
}
