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
		//게시글 전체 조회 쿼리
		String sql="";
		sql+="SELECT boardno,writedate,title,content,usernum,boardtypenum";
		sql+=" FROM board";
		
		List list = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Board board = new Board();
				
				board.setBoardno( rs.getInt("boardno") );
				board.setWritedate( rs.getDate("writedate") );
				board.setTitle( rs.getString("title") );
				board.setContent( rs.getString("content") );
				board.setUsernum(rs.getInt("usernum"));
				board.setBoardtypenum( rs.getInt("boardtypenum") );
		
				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return list;
		
	}

	@Override
	public List selectnoticeAll() {
		//게시글 전체 조회 쿼리
				String sql="";
				sql+="SELECT boardno,writedate,title,content,usernum,boardtypenum";
				sql+=" FROM board";
				sql+=" WHERE boardtypenum=1";
				
				List list = new ArrayList();
				
				try {
					ps = conn.prepareStatement(sql);
					
					rs = ps.executeQuery();
					
					while( rs.next() ) {
						Board board = new Board();
						
						board.setBoardno( rs.getInt("boardno") );
						board.setWritedate( rs.getDate("writedate") );
						board.setTitle( rs.getString("title") );
						board.setContent( rs.getString("content") );
						board.setUsernum(rs.getInt("usernum"));
						board.setBoardtypenum( rs.getInt("boardtypenum") );
				
						list.add(board);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				return list;
				
			}

	@Override
	public List selectbulletinAll() {
		//게시글 전체 조회 쿼리
				String sql="";
				sql+="SELECT boardno,writedate,title,content,usernum,boardtypenum";
				sql+=" FROM board";
				sql+=" WHERE boardtypenum=2";
				
				List list = new ArrayList();
				
				try {
					ps = conn.prepareStatement(sql);
					
					rs = ps.executeQuery();
					
					while( rs.next() ) {
						Board board = new Board();
						
						board.setBoardno( rs.getInt("boardno") );
						board.setWritedate( rs.getDate("writedate") );
						board.setTitle( rs.getString("title") );
						board.setContent( rs.getString("content") );
						board.setUsernum(rs.getInt("usernum"));
						board.setBoardtypenum( rs.getInt("boardtypenum") );
				
						list.add(board);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				return list;
				
			}
	
	@Override
	public List selectreportAll() {
		//게시글 전체 조회 쿼리
				String sql="";
				sql+="SELECT boardno,writedate,title,content,usernum,boardtypenum";
				sql+=" FROM board";
				sql+=" WHERE boardtypenum=3";
				
				List list = new ArrayList();
				
				try {
					ps = conn.prepareStatement(sql);
					
					rs = ps.executeQuery();
					
					while( rs.next() ) {
						Board board = new Board();
						
						board.setBoardno( rs.getInt("boardno") );
						board.setWritedate( rs.getDate("writedate") );
						board.setTitle( rs.getString("title") );
						board.setContent( rs.getString("content") );
						board.setUsernum(rs.getInt("usernum"));
						board.setBoardtypenum( rs.getInt("boardtypenum") );
				
						list.add(board);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				return list;
				
			}

}