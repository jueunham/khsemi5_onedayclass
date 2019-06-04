package one.service.impl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dao.face.BoardDao;
import one.dao.impl.BoardDaoImpl;
import one.dto.Board;
import one.service.face.BoardService;

public class BoardServiceImpl implements BoardService {

	//BoardDao 객체
	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public List getList() {
		return boardDao.selectAll();
	}

	@Override
	public List getnoticeList() {
		return boardDao.selectnoticeAll();
	}

	@Override
	public List getbulletinList() {
		return boardDao.selectbulletinAll();
	}

	@Override
	public List getreportList() {
		return boardDao.selectreportAll();
	}


}
