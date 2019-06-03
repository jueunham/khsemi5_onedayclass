package one.service.impl;


import java.util.List;

import one.dao.face.BoardDao;
import one.dao.face.ClassDao;
import one.dao.impl.BoardDaoImpl;
import one.dao.impl.ClassDaoImpl;
import one.service.face.BoardService;

public class BoardServiceImpl implements BoardService {

	//BoardDao 객체
	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public List getList() {
		return boardDao.selectAll();
	}

}
