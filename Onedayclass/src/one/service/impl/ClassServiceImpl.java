package one.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import one.dao.face.ClassDao;
import one.dao.impl.ClassDaoImpl;
import one.dto.ClassFile;
import one.dto.DayClass;
import one.service.face.ClassService;
import one.util.Paging;

public class ClassServiceImpl implements ClassService {

	//ClassDao 객체
	private ClassDao classDao = new ClassDaoImpl();

	 @Override
	public List getList(Paging paging) {
		return classDao.selectAll(paging);
	}

	 @Override
	public List getNotPagingList() {
	      return classDao.selectNotPagingAll();
	}

	@Override
	public void uploadClass(HttpServletRequest req) {
		
		DateFormat sdFormat = new SimpleDateFormat("mm/dd/yyyy");

		DayClass dayClass = null;
		ClassFile classFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			return;
			
		} else {
			//파일업로드를 사용하고 있을 경우
			dayClass = new DayClass();
			
			// 디스크 팩토리
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			//메모리 처리 사이즈
			factory.setSizeThreshold(1*1024*1024); //1MB
			
			//임시 저장소
			File repository = new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);
			
			//업로드 객체 생성
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//용량 제한 설정 :  10MB
			upload.setFileSizeMax(10*1024*1024);
			
			//form-data 추출 
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			//파싱된 데이터 처리 반복자
			Iterator<FileItem> iter = items.iterator();
			
			//요청정보 처리
			while(iter.hasNext()) {
				FileItem item = iter.next();
				
				// 빈 파일 처리
				if( item.getSize() <= 0 )	continue;
				
				// 빈 파일이 아닐 경우
				if( item.isFormField() ) {
					
					try {
						//클래스 이름
						if("className".equals(item.getFieldName())) {
							dayClass.setClassname(item.getString("utf-8"));							
						}
						//클래스 소개
						if("classContent".equals(item.getFieldName())) {
							dayClass.setClasscontent(item.getString("utf-8"));							
						}
						//강의 요일
						if("classDay".equals(item.getFieldName())) {
//							dayClass.setClassday(Date sdFormat.parse(item.getString("utf-8"))); 
						}
						//강의시간
						if("classTime".equals(item.getFieldName())) {
							dayClass.setClasstime(item.getString("utf-8"));							
						}
						//강의장소
						if("classPlace".equals(item.getFieldName())) {
							dayClass.setClassplace(item.getString("utf-8"));							
						}
						//강의료
						if("classPrice".equals(item.getFieldName())) {
							dayClass.setClassprice(Integer.parseInt(item.getString("utf-8")));
						}
						
						//강의진행시간
						if("classRunningTime".equals(item.getFieldName())) {
							dayClass.setClassrunningtime(Integer.parseInt(item.getString("utf-8")));
						}
						
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
//					 등록 호스트 처리
					dayClass.setUsernum((int) req.getSession().getAttribute("usernum"));
					System.out.println(dayClass.getUsernum());

					
				} else {
					UUID uuid = UUID.randomUUID();
					
					String u = uuid.toString().split("-")[4];
					
					//로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("upload")
						, stored);
					
					classFile = new ClassFile();
					classFile.setOriginName(item.getName());
					classFile.setStoredName(stored);
					classFile.setFilesize(item.getSize());
					
					try {
						// 실제 업로드
						item.write(up);
						
						// 임시 파일 삭제
						item.delete();
						
					} catch (Exception e) {
						e.printStackTrace();
					} // try end
				}
				
			}
			
		}
		
		int classnum = classDao.selectClassnum();
		
		if(dayClass != null) {
			dayClass.setClassnum(classnum);
			
			classDao.insert(dayClass);
			
		}
		
		if(classFile!=null) {
			classFile.setClassNum(classnum);
			classDao.insertFile(classFile);
		}
		
	}

	@Override
	public Paging getCurPage(HttpServletRequest req) {

		//전달 파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		// 전체 클래스 수
		int totalCount = classDao.selectCntAll();
		
		// 페이징 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public DayClass getClassnum(HttpServletRequest req) {
		
		//전달파라미터 classnum파싱
		String param = req.getParameter("classnum");
		int classnum = 0;
		if( param!=null && !"".equals(param) ) {
			classnum = Integer.parseInt(param);
		}

		System.out.println(classnum);
		
		DayClass dayclass = new DayClass();
		dayclass.setClassnum(classnum);
		
		
		return dayclass;
	}

	@Override
	public DayClass view(DayClass viewDayclass) {
		
		return classDao.selectDayClasByClassnum(viewDayclass);
	}

	@Override
	public void updateClass(HttpServletRequest req) {
		DayClass dayClass = null;
		ClassFile classFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			//파일 첨부가 없는 경우
			dayClass = new DayClass();
			
			dayClass.setClassname(req.getParameter("className"));
			dayClass.setClasscontent(req.getParameter("classContent"));
//			dayClass.setClassday(req.getParameter("classDay"));
			dayClass.setClasstime(req.getParameter("classTime"));
			dayClass.setClassrunningtime(Integer.parseInt(req.getParameter("classRunningTime")));
			dayClass.setClassplace(req.getParameter("classPlace"));
			dayClass.setClassprice(Integer.parseInt(req.getParameter("classPrice")));
			
			
		} else {
			dayClass = new DayClass();
			
			//디스크팩토리
			DiskFileItemFactory factory = new DiskFileItemFactory();

			//메모리처리 사이즈
			factory.setSizeThreshold(1 * 1024 * 1024); //1MB

			//임시 저장소
			File repository=new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);
			
			//업로드 객체 생성
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//용량 제한 설정 : 10MB
			upload.setFileSizeMax(10 * 1024 * 1024);
			
			//form-data 추출 
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			//파싱된 데이터 처리 반복자
			Iterator<FileItem> iter = items.iterator();
			
			//요청정보 처리
			while( iter.hasNext() ) {
				FileItem item = iter.next();
				
				// 빈 파일 처리
				if( item.getSize() <= 0 )	continue;
				
				// 빈 파일이 아닐 경우
				if( item.isFormField() ) {
					try {
						if("classNum".equals(item.getFieldName())) {
							dayClass.setClassnum(Integer.parseInt(item.getString()));
						}
						
						if("className".equals(item.getFieldName())) {
							dayClass.setClassname(item.getString("utf-8"));							
						}
						//클래스 소개
						if("classContent".equals(item.getFieldName())) {
							dayClass.setClasscontent(item.getString("utf-8"));							
						}
						//강의 요일
						if("classDay".equals(item.getFieldName())) {
//							dayClass.setClassday(sdFormat.parse(item.getString("utf-8"))); 
						}
						//강의시간
						if("classTime".equals(item.getFieldName())) {
							dayClass.setClasstime(item.getString("utf-8"));							
						}
						//강의장소
						if("classPlace".equals(item.getFieldName())) {
							dayClass.setClassplace(item.getString("utf-8"));							
						}
						//강의료
						if("classPrice".equals(item.getFieldName())) {
							dayClass.setClassprice(Integer.parseInt(item.getString("utf-8")));
						}
						
						//강의진행시간
						if("classRunningTime".equals(item.getFieldName())) {
							dayClass.setClassrunningtime(Integer.parseInt(item.getString("utf-8")));
						}
						
//						 등록 호스트 처리
						dayClass.setUsernum((int) req.getSession().getAttribute("usernum"));

					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
				} else {
					UUID uuid = UUID.randomUUID();
//					System.out.println(uuid);
					
					String u = uuid.toString().split("-")[4];
//					System.out.println(u);
					// -----------------
					
					//로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(
						req.getServletContext().getRealPath("upload")
						, stored);
					
					classFile = new ClassFile();
					classFile.setOriginName(item.getName());
					classFile.setStoredName(stored);
					classFile.setFilesize(item.getSize());
					
					try {
						// 실제 업로드
						item.write(up);
						
						// 임시 파일 삭제
						item.delete();
						
					} catch (Exception e) {
						e.printStackTrace();
					} // try end
				} //if end
			} //while end
		} //if(!isMultipart) end
		

//		System.out.println(board);
//		System.out.println(boardFile);
		
		if(dayClass != null) {
			
			classDao.update(dayClass);
		}
		
		if(classFile != null) {
			classFile.setClassNum(dayClass.getClassnum());
			classDao.insertFile(classFile);
		}
		
	}

	@Override
	public ClassFile viewFile(DayClass viewDayclass) {
		return classDao.selectFile(viewDayclass);
	}

	@Override
	public DayClass getCntuserid(HttpServletRequest req) {
		String param = req.getParameter("userid");
	      String userid = null;
	      if( param != null && !"".equals(param) ) { 
	         userid = param; 
	      }
	      
	      DayClass dayClass = new DayClass();
//	      dayClass.setUserid(userid);
	      
	      classDao.selectListByUserid(userid);
	      
	      return dayClass;
	}

	@Override
	public void delete(DayClass dayClass) {
		classDao.deleteFile(dayClass);
		
		classDao.delete(dayClass);
		
	}

	
}
