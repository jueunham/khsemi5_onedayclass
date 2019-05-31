package one.service.impl;


import java.util.List;

import one.dao.face.MemberDao;
import one.dao.impl.MemberDaoImpl;
import one.service.face.MemberService;

public class MemberSerivceImpl implements MemberService {

	//MemberDao 객체
	private MemberDao memberDao = new MemberDaoImpl();
	
	@Override
	public List getList() {
		return memberDao.selectAll();
	}
}
