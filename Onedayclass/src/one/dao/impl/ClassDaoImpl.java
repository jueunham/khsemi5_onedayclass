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


public class ClassDaoImpl implements ClassDao {

		//DB관련 객체
		private Connection conn = DBConn.getConnection(); 

		private PreparedStatement ps = null;
		private ResultSet rs = null;

		@Override
		public List selectAll() {
			//파일업로드 기록 조회쿼리
					String sql = "";
					sql+="SELECT classnum,classname,classcontent,classday,classtime,classplace,classrunningtime";
					sql+=" FROM dayclass";
								
					List list = new ArrayList();
					try {
						ps = conn.prepareStatement(sql);
						
						rs = ps.executeQuery();
						
						while( rs.next() ) {
							DayClass dayclass = new DayClass();
							
							dayclass.setClassnum( rs.getInt("classnum") );
							dayclass.setClassname( rs.getString("classname") );
							dayclass.setClasscontent( rs.getString("classcontent") );
							dayclass.setClassday( rs.getString("classday") );
							dayclass.setClasstime(rs.getString("classtime"));
							dayclass.setClassplace( rs.getString("classplace") );
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
			sql += " VALUES (?, ?, ?, ?, ?, ?, 15000, 30, 100 )";
			
			try {
				//DB작업
				ps = conn.prepareStatement(sql);
				ps.setInt(1, dayClass.getClassnum());
				ps.setString(2, dayClass.getClassname());
				ps.setString(3, dayClass.getClasscontent());
				ps.setString(4, dayClass.getClassday());
				ps.setString(5, dayClass.getClasstime());
				ps.setString(6, dayClass.getClassplace());
//				ps.setInt(7, dayClass.getClassprice());
//				ps.setInt(8, dayClass.getClassrunningtime());
//				ps.setInt(9, dayClass.getUsernum());
				
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
			}			// TODO Auto-generated method stub
			
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
				
			}