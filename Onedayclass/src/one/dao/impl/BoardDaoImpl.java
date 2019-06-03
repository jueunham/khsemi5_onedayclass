package one.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import one.dao.face.BoardDao;
import one.dbutil.DBConn;
import one.dto.Board;
import one.dto.DayClass;

public class BoardDaoImpl implements BoardDao {

	//DB관련 객체
	private Connection conn = DBConn.getConnection(); 

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List selectAll() {
		//파일업로드 기록 조회쿼리
		String sql="";
		sql+="SELECT boardno,writedate,title,content,usernum,boardtypenum";
		sql+="FROM board";
		sql+="ORDER BY boardno DESC";
		
		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Board board = new Board();
				
				board.setBoardno( rs.getInt("classnum") );
				board.setWritedate( rs.getDate("classname") );
				board.setTitle( rs.getString("classcontent") );
				board.setContent( rs.getString("classday") );
				board.setUsernum(rs.getInt("classtime"));
				board.setBoardtypenum( rs.getInt("classplace") );
		
				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return list;
		
	}

}