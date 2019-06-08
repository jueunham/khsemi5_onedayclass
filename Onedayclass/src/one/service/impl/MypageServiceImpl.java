package one.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import one.dao.face.MypageDao;
import one.dao.impl.MypageDaoImpl;
import one.dto.Member;
import one.dto.UserInterList;
import one.service.face.MypageService;

public class MypageServiceImpl implements MypageService {
	
	private MypageDao mypageDao = new MypageDaoImpl();

	@Override
	public List<Map<String, Object>> getList() {
		return mypageDao.selectClass();
	}
	
	
	@Override
	public Member getUserNum(HttpServletRequest req) {

		String param = req.getParameter("usernum");
		int usernum = 0;
		if( param != null && !"".equals(param) ) { 
			usernum = Integer.parseInt(param); 
		}
		
		Member member = new Member();
		member.setUsernum(usernum);
		
		return member;
	}
	
	public Member view(Member member) {
		return mypageDao.selectUserNum(member);
	}
	

	@Override
	public void updateInfo(HttpServletRequest req) {
		
		Member member = new Member();
		UserInterList userinter = new UserInterList();
		
		String userPhone = req.getParameter("userphone");
		
		//java.lang.NumberFormatException: null
		try {
			int interListNum = Integer.parseInt(req.getParameter("interListNum"));
			userinter.setInterListNum(interListNum);
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		member.setUserphone(userPhone);
		

		mypageDao.updateInfoPhone(member);
		mypageDao.updateInfoInter(userinter);
		System.out.println(member);
		System.out.println(userinter);
		
	}
	
	@Override
	public List<Map<String, Object>> getWishList() {
		return mypageDao.selectWishList();
	}
	
	@Override
	public List<Map<String, Object>> getRevQue() {
		return mypageDao.selectRevQue();
	}
	
}
