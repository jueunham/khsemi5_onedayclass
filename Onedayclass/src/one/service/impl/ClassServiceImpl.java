package one.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
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

public class ClassServiceImpl implements ClassService {

	//ClassDao 객체
	private ClassDao classDao = new ClassDaoImpl();

	 @Override
	public List getList() {
		return classDao.selectAll();
	}

	@Override
	public void uploadClass(HttpServletRequest req) {
		
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
							dayClass.setClassday(item.getString("utf-8"));							
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
//						if("".equals(item.getFieldName())) {
//							dayClass.setClassprice(item.getString("utf-8"));							
//						}
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
					// 등록 호스트 처리
//					dayClass.setUsernum((int) req.getSession().getAttribute("userNum"));
					
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

}
