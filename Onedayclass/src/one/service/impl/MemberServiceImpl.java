package one.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dao.face.MemberDao;
import one.dao.impl.MemberDaoImpl;
import one.dto.Member;
import one.service.face.MemberService;

public class MemberServiceImpl implements MemberService {
	
	//MemberDao 객체
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public Member getLoginMember(HttpServletRequest req) {
		Member member = new Member();
		
		member.setUserid(req.getParameter("userid"));
		member.setUserpw(req.getParameter("userpw"));
		
		return member;
	}

	@Override
	public Member getJoinMember(HttpServletRequest req) {
		Member member = new Member();
		
	      // 전달파라미터 userno 파싱
	      String param = req.getParameter("userNum");
	      int userNum = 0;
	      if( param!=null && !"".equals(param) ) {
	         userNum = Integer.parseInt(param);
	      }
	      
	      // 전달파라미터 userphone 파싱
	      param = req.getParameter("userPhone");
	      int userPhone = 0;
	      if( param!=null && !"".equals(param) ) {
	         userPhone = Integer.parseInt(param);
	      }
		
		member.setUsernum(userNum);
		member.setUsername(req.getParameter("userName"));
		member.setUserid(req.getParameter("userid"));
		member.setUserpw(req.getParameter("userpw"));
		member.setUserphone(userPhone);
		member.setUserlevel(req.getParameter("userLevel"));
		
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

}
