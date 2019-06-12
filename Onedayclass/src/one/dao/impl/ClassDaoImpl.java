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
			//파일업로드 기록 조회쿼리
			String sql = "";
			sql += "SELECT * FROM (";
			sql += " 	SELECT rownum rnum, B.* FROM (";
			sql += " 		SELECT * FROM dayclass";
			sql += " 		ORDER BY classnum DESC";
			sql += " 	) B";
			sql += " 	ORDER BY rnum";
			sql += " ) DAYCLASS";
			sql += " WHERE rnum BETWEEN ? AND ?";

								
			List list = new ArrayList();
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, paging.getStartNo());
				ps.setInt(2, paging.getEndNo());
				
				rs = ps.executeQuery();
						
				while( rs.next() ) {
					DayClass dayclass = new DayClass();
					
					dayclass.setClassnum( rs.getInt("classnum") );
					dayclass.setClassname( rs.getString("classname") );
					dayclass.setClasscontent( rs.getString("classcontent") );
					dayclass.setClassday( rs.getDate("classday") );
					dayclass.setClasstime(rs.getString("classtime"));
					dayclass.setClassplace( rs.getString("classplace") );
					dayclass.setClassprice(rs.getInt("classprice"));
					dayclass.setClassrunningtime(rs.getInt("classrunningtime"));
					dayclass.setUsernum(rs.getInt("usernum"));
						
					list.add(dayclass);
				}

					} catch (SQLException e) {
						e.printStackTrace();
					}
							
					return list;
					
				}
		
		
		@Override
		public List selectNotPagingAll() {
			 String sql = "";
		      sql += "SELECT *";
		      sql += " FROM dayclass";
		   
		      
		      List list = new ArrayList();
		      
		      try {
		        ps = conn.prepareStatement(sql);
		        rs = ps.executeQuery();
		         
		        DayClass dayclass = new DayClass();
					
				dayclass.setClassnum( rs.getInt("classnum") );
				dayclass.setClassname( rs.getString("classname") );
				dayclass.setClasscontent( rs.getString("classcontent") );
				dayclass.setClassday( rs.getDate("classday") );
				dayclass.setClasstime(rs.getString("classtime"));
				dayclass.setClassplace( rs.getString("classplace") );
				dayclass.setClassprice(rs.getInt("classprice"));
				dayclass.setClassrunningtime(rs.getInt("classrunningtime"));
				dayclass.setUsernum(rs.getInt("usernum"));
						
				list.add(dayclass);

		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		            
		      return list;

		}

		@Override
		public int selectClassnum() {
			//다음 게시글 번호 조회 쿼리
			String sql = "";
			sql += "SELECT dayclass_seq.nextval";
			sql += " FROM dual";
			
			//게시글번호
			int classnum = 0;
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				//결과 담기
				while(rs.next()) {
					classnum = rs.getInt(1);
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
			
			//게시글 번호 반환
			return classnum;
		}

		@Override
		public void insert(DayClass dayClass) {
			//다음 게시글 번호 조회 쿼리
			String sql = "";
			sql += "INSERT INTO dayclass(classnum,classname,classcontent,classday,classtime, classplace, classprice, classrunningtime, usernum) ";
			sql += " VALUES (?, ?, ?, ?, ?, ?, ? , ?, ? )";
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setInt(1, dayClass.getClassnum());
				ps.setString(2, dayClass.getClassname());
				ps.setString(3, dayClass.getClasscontent());
				ps.setDate(4, dayClass.getClassday());
				ps.setString(5, dayClass.getClasstime());
				ps.setString(6, dayClass.getClassplace());
				ps.setInt(7, dayClass.getClassprice());
				ps.setInt(8, dayClass.getClassrunningtime());
				ps.setInt(9, dayClass.getUsernum());
				
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
		public void insertFile(ClassFile classFile) {
			String sql = "";
			sql += "INSERT INTO classFile(fileno,classNum,originname,storedname,filesize) ";
			sql += " VALUES (classfile_seq.nextval, ?, ?, ?, ?)";
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setInt(1, classFile.getClassNum());
				ps.setString(2, classFile.getOriginName());
				ps.setString(3, classFile.getStoredName());
				ps.setLong(4, classFile.getFilesize());

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
		public int selectCntAll() {
			//전체 게시글 수 조회 쿼리
			String sql = "";
			sql+="SELECT count(*)";
			sql+=" FROM dayclass";
		
			int totalCount = 0;
			try {
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				while( rs.next() ) {
					totalCount = rs.getInt(1);
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
					
			return totalCount;
		}

		@Override
		public DayClass selectDayClasByClassnum(DayClass viewDayclass) {
			//게시글 조회쿼리
			String sql = "";
			sql += "SELECT * FROM dayclass";
			sql += " WHERE classnum = ?";
			
			try {
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, viewDayclass.getClassnum());
				
				rs = ps.executeQuery();
				
				while( rs.next() ) {
					
					viewDayclass.setClassnum( rs.getInt("classnum") );
					viewDayclass.setClassname( rs.getString("classname") );
					viewDayclass.setClasscontent( rs.getString("classcontent") );
					viewDayclass.setClassday( rs.getDate("classday") );
					viewDayclass.setClasstime(rs.getString("classtime"));
					viewDayclass.setClassplace( rs.getString("classplace") );
					viewDayclass.setClassprice(rs.getInt("classprice"));
					viewDayclass.setClassrunningtime(rs.getInt("classrunningtime"));
					viewDayclass.setUsernum(rs.getInt("usernum"));
					
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
			return viewDayclass;
		}

		@Override
		public void update(DayClass dayClass) {
			
			String sql = "";
			sql += "UPDATE dayclass";
			sql += " SET classname = ?,";
			sql += " 	classcontent = ?,";
			sql += " 	classday = ?,";
			sql += " 	classtime = ?,";
			sql += " 	classrunningtime = ?,";
			sql += " 	classplace = ?,";
			sql += " 	classprice = ?";

			sql += " WHERE classnum = ?";
			
			PreparedStatement ps = null; 
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setString(1, dayClass.getClassname());
				ps.setString(2, dayClass.getClasscontent());
				ps.setDate(3, dayClass.getClassday());
				ps.setString(4, dayClass.getClasstime());
				ps.setInt(5, dayClass.getClassrunningtime());
				ps.setString(6, dayClass.getClassplace());
				ps.setInt(7, dayClass.getClassprice());
				ps.setInt(8, dayClass.getClassnum());

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
		public ClassFile selectFile(DayClass viewDayclass) {
			
			String sql = "";
			sql += "SELECT * FROM classfile";
			sql += " WHERE classnum = ?";
			
			ClassFile classFile = new ClassFile();
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setInt(1, viewDayclass.getClassnum());

				rs = ps.executeQuery();
				
				while(rs.next()) {
				
					classFile.setFileno( rs.getInt("fileno") );
					classFile.setClassNum( rs.getInt("classnum") );
					classFile.setOriginName( rs.getString("originname") );
					classFile.setStoredName( rs.getString("storedname") );
					classFile.setFilesize( rs.getLong("filesize") );
					classFile.setWriteDate( rs.getDate("writedate") );
					
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
			
			return classFile;
		}


		@Override
		public List selectListByUserid(String userid) {
			  String sql = "";
		      sql += "SELECT *";
		      sql += " FROM dayclass";
		      sql += " WHERE userid = ?";
		   
		      
		      List hostClassList = new ArrayList();
		      
		      try {
		    	  ps = conn.prepareStatement(sql);
		    	  ps.setString(1, userid);
		    	  
		        rs = ps.executeQuery();
		         
		        DayClass dayclass = new DayClass();
					
				dayclass.setClassnum( rs.getInt("classnum") );
				dayclass.setClassname( rs.getString("classname") );
				dayclass.setClasscontent( rs.getString("classcontent") );
				dayclass.setClassday( rs.getDate("classday") );
				dayclass.setClasstime(rs.getString("classtime"));
				dayclass.setClassplace( rs.getString("classplace") );
				dayclass.setClassprice(rs.getInt("classprice"));
				dayclass.setClassrunningtime(rs.getInt("classrunningtime"));
						
				hostClassList.add(dayclass);

		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		            
		      return hostClassList;
		}


		@Override
		public void deleteFile(DayClass dayClass) {
			String sql = "";
			sql += "DELETE classfile";
			sql += " WHERE classnum = ?";
			
			//DB 객체
			PreparedStatement ps = null; 
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setInt(1, dayClass.getClassnum());

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
		public void delete(DayClass dayClass) {
			
			String sql = "";
			sql += "DELETE dayclass";
			sql += " WHERE classnum = ?";
			
			//DB 객체
			PreparedStatement ps = null; 
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setInt(1, dayClass.getClassnum());

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