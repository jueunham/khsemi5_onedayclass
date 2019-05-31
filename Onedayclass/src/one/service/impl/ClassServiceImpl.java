package one.service.impl;

import java.util.List;

import one.dao.face.ClassDao;
import one.dao.impl.ClassDaoImpl;
import one.service.face.ClassService;

public class ClassServiceImpl implements ClassService {

	//ClassDao 객체
	private ClassDao classDao = new ClassDaoImpl();

	@Override
	public List getList() {
		return classDao.selectAll();
	}

}
