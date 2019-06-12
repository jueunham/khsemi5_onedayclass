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
import one.util.Paging;

public class BoardDaoImpl implements BoardDao {

	// DB관련 객체
	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	

	@Override
	public Board selectBoardByBoardno(Board viewBoard) {
		// 게시글 조회쿼리
		String sql = "";
		sql += "SELECT boardno,wirteDate,title,content,userNum,boardtypeNum FROM board";
		sql += " WHERE boardno = ?";

		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, viewBoard.getBoardno());

			rs = ps.executeQuery();

			while (rs.next()) {

				viewBoard.setBoardno(rs.getInt("boardno"));
				viewBoard.setWritedate(rs.getDate("writedate"));
				viewBoard.setTitle(rs.getString("title"));
				viewBoard.setContent(rs.getString("content"));
				viewBoard.setUsernum(rs.getInt("usernum"));
				viewBoard.setBoardtypenum(rs.getInt("boardtypenum"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return viewBoard;
	}

	@Override
	public int selectBoardno() {
		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "SELECT board_seq.nextval";
		sql += " FROM dual";

		// 게시글번호
		int boardno = 0;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// 결과 담기
			while (rs.next()) {
				boardno = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 게시글 번호 반환
		return boardno;
	}

	@Override
	public void insert(Board board) {
		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "INSERT INTO board(boardno,wirteDate,title,content,userNum,boardtypeNum) ";
		sql += " VALUES (?, ?, ?, ?, ?, ?)";

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());
			ps.setDate(2, board.getWritedate());
			ps.setString(3, board.getTitle());
			ps.setString(4, board.getContent());
			ps.setInt(5, board.getUsernum());
			ps.setInt(6, board.getBoardtypenum());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Board board) {
//		System.out.println(board);
		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "UPDATE board";
		sql += " SET title = ?,";
		sql += " 	content = ?";
		sql += " WHERE boardno = ?";

		// DB 객체
		PreparedStatement ps = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setInt(3, board.getBoardno());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Board board) {
		// 다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE board";
		sql += " WHERE boardno = ?";

		// DB 객체
		PreparedStatement ps = null;

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				// DB객체 닫기
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int selectCntAll() {
		// 전체 게시글 수 조회 쿼리
		String sql = "";
		sql += "SELECT count(*)";
		sql += " FROM board";

		int totalCount = 0;
		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				totalCount = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 해제
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return totalCount;
	}

	@Override
	public List selectAll() {

		// 게시판 전체 기록 조회쿼리
		String sql = "";
		sql += "SELECT boardno,writedate,title,content,usernum,boardtypenum,hit";
		sql += " FROM board";
	
		
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
				board.setHit(rs.getInt("hit"));
		
				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return list;
		
	}
	
	@Override
	public List selectnoticeAll() {
		//공지사항 게시글 전체 조회 쿼리
				String sql="";
				sql+="SELECT boardno,writedate,title,content,usernum,boardtypenum,hit";
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
						board.setHit(rs.getInt("hit"));
				
						list.add(board);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				return list;
				
			}

	@Override
	public List selectbulletinAll() {
		//자유게시판 게시글 전체 조회 쿼리
				String sql="";
				sql+="SELECT boardno,writedate,title,content,usernum,boardtypenum,hit";
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
						board.setHit(rs.getInt("hit"));
				
						list.add(board);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				return list;
				
			}
	
	@Override
	public List selectreportAll() {
		//신고게시판 게시글 전체 조회 쿼리
				String sql="";
				sql+="SELECT boardno,writedate,title,content,usernum,boardtypenum,hit";
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
						board.setHit(rs.getInt("hit"));
				
						list.add(board);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
						
				return list;
				
			}

	@Override
	public void deleteBoardFileList(String names) {
		String sql = "DELETE FROM boardFile WHERE boardno IN ( "+names+" )";
		
		try {
			ps = conn.prepareStatement(sql);
			
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
	public void deleteBoardList(String names) {
		String sql = "DELETE FROM board WHERE boardno IN ( "+names+" )";
		
		try {
			ps = conn.prepareStatement(sql);
			
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


}