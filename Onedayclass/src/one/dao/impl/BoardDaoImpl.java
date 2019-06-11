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
import one.util.Paging;
import one.dto.BoardFile;
import one.dto.Member;

public class BoardDaoImpl implements BoardDao {
   // DB관련 객체
   private Connection conn = DBConn.getConnection();

   private PreparedStatement ps = null;
   private ResultSet rs = null;
   
   @Override
   public List selectAll(Paging paging) {
	   // 게시글 전체 조회 쿼리
	      String sql = "";
	      sql += "SELECT * FROM (";
	      sql += " SELECT rownum rnum, B.* FROM (";
	      sql += " SELECT boardno, writedate, title, content, usernum, userid, boardtypenum, hit FROM board";
	      sql += " ORDER BY boardno DESC";
	      sql += "   ) B";
	      sql += "   ORDER BY rnum";
	      sql += " ) BOARD";
	      sql += " WHERE rnum BETWEEN ? AND ?";

	      List list = new ArrayList();

	      try {
	         ps = conn.prepareStatement(sql);

	         ps.setInt(1, paging.getStartNo());
	         ps.setInt(2, paging.getEndNo());

	         rs = ps.executeQuery();

	         while (rs.next()) {
	            Board board = new Board();

	            board.setBoardno(rs.getInt("boardno"));
	            board.setWritedate(rs.getDate("writedate"));
	            board.setTitle(rs.getString("title"));
	            board.setContent(rs.getString("content"));
	            board.setUsernum(rs.getInt("usernum"));
	            board.setUserid(rs.getString(("userid")));
	            board.setBoardtypenum(rs.getInt("boardtypenum"));
	            board.setHit(rs.getInt("hit"));

	            list.add(board);
	         }

	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

	      return list;
   }
   @Override
   public List selectnoticeAll(Paging paging) {

      // 게시글 전체 조회 쿼리
      String sql = "";
      sql += "SELECT * FROM (";
      sql += " SELECT rownum rnum, B.* FROM (";
      sql += " SELECT boardno, writedate, title, content, usernum, userid, boardtypenum, hit FROM board";
      sql += " WHERE boardtypenum=1";
      sql += " ORDER BY boardno DESC";
      sql += "   ) B";
      sql += "   ORDER BY rnum";
      sql += " ) BOARD";
      sql += " WHERE rnum BETWEEN ? AND ?";

      List list = new ArrayList();

      try {
         ps = conn.prepareStatement(sql);

         ps.setInt(1, paging.getStartNo());
         ps.setInt(2, paging.getEndNo());

         rs = ps.executeQuery();

         while (rs.next()) {
            Board board = new Board();

            board.setBoardno(rs.getInt("boardno"));
            board.setWritedate(rs.getDate("writedate"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setUsernum(rs.getInt("usernum"));
            board.setUserid(rs.getString(("userid")));
            board.setBoardtypenum(rs.getInt("boardtypenum"));
            board.setHit(rs.getInt("hit"));

            list.add(board);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;

   }

   @Override
   public List selectbulletinAll(Paging paging) {

      // 게시글 전체 조회 쿼리
      String sql = "";
      sql += "SELECT * FROM (";
      sql += " SELECT rownum rnum, B.* FROM (";
      sql += " SELECT boardno, writedate, title, content, usernum, userid, boardtypenum, hit FROM board";
      sql += " WHERE boardtypenum=2";
      sql += " ORDER BY boardno DESC";
      sql += "   ) B";
      sql += "   ORDER BY rnum";
      sql += " ) BOARD";
      sql += " WHERE rnum BETWEEN ? AND ?";

      List list = new ArrayList();

      try {
         ps = conn.prepareStatement(sql);

         ps.setInt(1, paging.getStartNo());
         ps.setInt(2, paging.getEndNo());

         rs = ps.executeQuery();

         while (rs.next()) {
            Board board = new Board();

            board.setBoardno(rs.getInt("boardno"));
            board.setWritedate(rs.getDate("writedate"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setUsernum(rs.getInt("usernum"));
            board.setUserid(rs.getString(("userid")));
            board.setBoardtypenum(rs.getInt("boardtypenum"));
            board.setHit(rs.getInt("hit"));

            list.add(board);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return list;

   }

   @Override
   public List selectreportAll(Paging paging) {
      
      // 게시글 전체 조회 쿼리
            String sql = "";
            sql += "SELECT * FROM (";
            sql += " SELECT rownum rnum, B.* FROM (";
            sql += " SELECT boardno, writedate, title, content, usernum, userid, boardtypenum, hit FROM board";
            sql += " WHERE boardtypenum=3";
            sql += " ORDER BY boardno DESC";
            sql += "   ) B";
            sql += "   ORDER BY rnum";
            sql += " ) BOARD";
            sql += " WHERE rnum BETWEEN ? AND ?";

            List list = new ArrayList();

            try {
               ps = conn.prepareStatement(sql);

               ps.setInt(1, paging.getStartNo());
               ps.setInt(2, paging.getEndNo());

               rs = ps.executeQuery();

               while (rs.next()) {
                  Board board = new Board();

                  board.setBoardno(rs.getInt("boardno"));
                  board.setWritedate(rs.getDate("writedate"));
                  board.setTitle(rs.getString("title"));
                  board.setContent(rs.getString("content"));
                  board.setUsernum(rs.getInt("usernum"));
                  board.setUserid(rs.getString(("userid")));
                  board.setBoardtypenum(rs.getInt("boardtypenum"));
                  board.setHit(rs.getInt("hit"));

                  list.add(board);
               }

            } catch (SQLException e) {
               e.printStackTrace();
            }

            return list;

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
   public void updateHit(Board viewBoard) {

      // 파일업로드 기록 조회쿼리
      String sql = "";
      sql += "UPDATE board";
      sql += " SET hit = hit + 1";
      sql += " WHERE boardno = ?";

      try {
         ps = conn.prepareStatement(sql);

         ps.setInt(1, viewBoard.getBoardno());

         ps.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            // 자원 해제
            if (ps != null)
               ps.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }

   }

   @Override
   public Board selectBoardByBoardno(Board viewBoard) {
      
      // 게시글 조회쿼리
      String sql = "";
      sql += "SELECT boardno,writedate,title,content,usernum,userid,boardtypenum FROM board";
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
            viewBoard.setUsernum(rs.getInt("userNum"));
            viewBoard.setUserid(rs.getString("userid"));
            viewBoard.setBoardtypenum(rs.getInt("boardtypeNum"));
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
   public void noticeinsert(Board board) {
      // 다음 게시글 번호 조회 쿼리
      String sql = "";
      sql += "INSERT INTO board(boardno,writeDate,title,content,usernum,userid,boardtypenum) ";
      sql += " VALUES (?, ?, ?, ?, ?, ?, 1)";

      try {
         // DB작업
         ps = conn.prepareStatement(sql);
         ps.setInt(1, board.getBoardno());
         ps.setDate(2, board.getWritedate());
         ps.setString(3, board.getTitle());
         ps.setString(4, board.getContent());
         ps.setInt(5, board.getUsernum());
         ps.setString(6, board.getUserid());

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
   public void bulletininsert(Board board) {
      // 다음 게시글 번호 조회 쿼리
      String sql = "";
      sql += "INSERT INTO board(boardno,title,content,usernum,userid,boardtypenum, hit) ";
      sql += " VALUES (?, ?, ?, (SELECT usernum FROM member WHERE userid = ?), ?, 2, 0)";

      try {
         // DB작업
         ps = conn.prepareStatement(sql);
         ps.setInt(1, board.getBoardno());
         ps.setString(2, board.getTitle());
         ps.setString(3, board.getContent());
//         ps.setInt(5, board.getUsernum());
         ps.setString(4, board.getUserid());
         ps.setString(5, board.getUserid());

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
   public void reportinsert(Board board) {
      // 다음 게시글 번호 조회 쿼리
      String sql = "";
      sql += "INSERT INTO board(boardno,writeDate,title,content,usernum,userid,boardtypenum) ";
      sql += " VALUES (?, ?, ?, ?, ?, ?, 3)";

      try {
         // DB작업
         ps = conn.prepareStatement(sql);
         ps.setInt(1, board.getBoardno());
         ps.setDate(2, board.getWritedate());
         ps.setString(3, board.getTitle());
         ps.setString(4, board.getContent());
         ps.setInt(5, board.getUsernum());
         ps.setString(6, board.getUserid());

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
   public void insertFile(BoardFile boardFile) {

      // 다음 게시글 번호 조회 쿼리
      String sql = "";
      sql += "INSERT INTO boardFile(fileno,boardno,originname,storedname,filesize) ";
      sql += " VALUES (boardfile_seq.nextval, ?, ?, ?, ?)";

      try {
         // DB작업
         ps = conn.prepareStatement(sql);
         ps.setInt(1, boardFile.getBoardno());
         ps.setString(2, boardFile.getOriginName());
         ps.setString(3, boardFile.getStoredName());
         ps.setLong(4, boardFile.getFilesize());

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
   public BoardFile selectFile(Board board) {
      // 다음 게시글 번호 조회 쿼리
      String sql = "";
      sql += "SELECT * FROM boardfile";
      sql += " WHERE boardno = ?";

      BoardFile boardFile = new BoardFile();

      try {
         // DB작업
         ps = conn.prepareStatement(sql);
         ps.setInt(1, board.getBoardno());

         rs = ps.executeQuery();

         while (rs.next()) {

            boardFile.setFileno(rs.getInt("fileno"));
            boardFile.setBoardno(rs.getInt("boardno"));
            boardFile.setOriginName(rs.getString("originname"));
            boardFile.setStoredName(rs.getString("storedname"));
            boardFile.setFilesize(rs.getLong("filesize"));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            // DB객체 닫기
            if (ps != null)
               ps.close();
            if (rs != null)
               rs.close();

         } catch (SQLException e) {
            e.printStackTrace();
         }
      }

      return boardFile;
   }

   @Override
   public BoardFile selectByFileno(int fileno) {
      // 다음 게시글 번호 조회 쿼리
      String sql = "";
      sql += "SELECT * FROM boardfile";
      sql += " WHERE fileno = ?";

      // DB 객체
      PreparedStatement ps = null;
      ResultSet rs = null;

      BoardFile boardFile = new BoardFile();

      try {
         // DB작업
         ps = conn.prepareStatement(sql);
         ps.setInt(1, fileno);

         rs = ps.executeQuery();

         while (rs.next()) {

            boardFile.setFileno(rs.getInt("fileno"));
            boardFile.setBoardno(rs.getInt("boardno"));
            boardFile.setOriginName(rs.getString("originname"));
            boardFile.setStoredName(rs.getString("storedname"));
            boardFile.setFilesize(rs.getLong("filesize"));
            boardFile.setWriteDate(rs.getDate("writedate"));

         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            // DB객체 닫기
            if (ps != null)
               ps.close();
            if (rs != null)
               rs.close();

         } catch (SQLException e) {
            e.printStackTrace();
         }
      }

      return boardFile;
   }

   @Override
   public void update(Board board) {
//      System.out.println(board);
      // 다음 게시글 번호 조회 쿼리
      String sql = "";
      sql += "UPDATE board";
      sql += " SET title = ?,";
      sql += "    content = ?";
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
   public void deleteFile(Board board) {
      // 다음 게시글 번호 조회 쿼리
      String sql = "";
      sql += "DELETE boardfile";
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
   public void deleteBoardFileList(String names) {
      // TODO Auto-generated method stub

   }

   @Override
   public void deleteBoardList(String names) {
      // TODO Auto-generated method stub

   }

}