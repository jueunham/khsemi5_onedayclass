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

import one.dao.face.MemberDao;
import one.dao.impl.MemberDaoImpl;
import one.dto.Member;
import one.dto.MemberFile;
import one.service.face.MemberService;

public class MemberServiceImpl implements MemberService {
   
   //MemberDao 객체
   private MemberDao memberDao = new MemberDaoImpl();
   
   @Override
   public Member getLoginMember(HttpServletRequest req) {
      Member member = new Member();
      
      member.setUserid(req.getParameter("userid"));
      member.setUserpw(req.getParameter("userpw"));
      member.setUserlevel(req.getParameter("userlevel"));
      return member;
   }

   @Override
   public Member getJoinMember(HttpServletRequest req) {
	   try {
		req.setCharacterEncoding("UTF-8");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      Member member = new Member();
      
         // 전달파라미터 usernum 파싱
         String param = req.getParameter("userNum");
         int userNum = 0;
         if( param!=null && !"".equals(param) ) {
            userNum = Integer.parseInt(param);
         }

         // 전달파라미터 userphone 파싱
         String ph1 = req.getParameter("ph1");
         String ph2 = req.getParameter("ph2");
         String ph3 = req.getParameter("ph3");
         String userphone = ph1+ph2+ph3;
         member.setUserphone(userphone);

      member.setUsernum(userNum);
      member.setUsername(req.getParameter("username"));
      member.setUserid(req.getParameter("userid"));
      member.setUserpw(req.getParameter("userpw"));
  
      member.setUserlevel(req.getParameter("userlevel"));
      
      return member;
   }
   
   @Override
   public boolean login(Member member) {

      if( memberDao.selectCntMemberByUseridAndUserpw(member) >= 1 ) {
         //로그인 성공
         return true;

      } else {
         //로그인 실패
         return false;
         
      }
      
   }

   @Override
   public Member getMemberByUserid(Member member) {
      return memberDao.selectMemberByUserid(member);
   }
   
   

   @Override
   public void join(Member member) {
      memberDao.insert(member);
   }

   @Override
   public List getList() {
      return memberDao.selectAll();
   }

	@Override
	public void updateinfo(HttpServletRequest req) {
//		Member member = new Member();
//		
//		String userphone = req.getParameter("userphone");
//		member.setUserphone(userphone);
//		System.out.println(userphone);
//		
//		
//	    String userid = (String) req.getSession().getAttribute("userid");
//	    member.setUserid(userid);
//		System.out.println(member.getUserid());
//		
//		memberDao.updateinfo(member);
		
		Member member = null;
		MemberFile memberFile = null;
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		if(!isMultipart) {
			//파일 첨부가 없는 경우
			member = new Member();
			
			member.setUserphone(req.getParameter("userphone"));
			
			
			
		} else {
			member = new Member();
			
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
						
						if("userphone".equals(item.getFieldName())) {
							member.setUserphone(item.getString("utf-8"));							
						}
						
//						 등록 호스트 처리
						member.setUserid((String) req.getSession().getAttribute("userid"));

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
					
					memberFile = new MemberFile();
					memberFile.setOriginName(item.getName());
					memberFile.setStoredName(stored);
					memberFile.setFilesize(item.getSize());
					
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
		
		if(member != null) {
			
			memberDao.updateinfo(member);
		}
		
		if(member != null) {
			memberFile.setUserid(member.getUserid());
			memberDao.insertFile(memberFile);
		}
		
	}

	@Override
	public MemberFile viewFile(Member meminfo) {
		return memberDao.selectFile(meminfo);
	}

}