package one.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import one.dao.face.ClassDao;
import one.dbutil.DBConn;
import one.dto.Dayclass;


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
							Dayclass dayclass = new Dayclass();
							
							dayclass.setClassnum( rs.getInt("classnum") );
							dayclass.setClassname( rs.getString("classname") );
							dayclass.setClasscontent( rs.getString("classcontent") );
							dayclass.setClassday( rs.getDate("classday") );
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
				
			}