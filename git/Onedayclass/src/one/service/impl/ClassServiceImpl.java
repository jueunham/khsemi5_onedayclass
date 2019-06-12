package one.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dao.face.ClassDao;
import one.dao.impl.ClassDaoImpl;

import one.dto.DayClass;
import one.service.face.ClassService;
import one.util.Paging;



public class ClassServiceImpl implements ClassService {
	
	private ClassDao classDao = new ClassDaoImpl();
	
	@Override
	public List getList(Paging paging) {
		return classDao.selectAll(paging);
				
	}
	

	@Override
	public Paging getCurPage(HttpServletRequest req) {
		// 전달파라미터 curPage 파싱
		String param = req.getParameter( "curPage" ) ;
		
		int curPage = 0 ;
		if ( param != null && !"".equals( param ) ) {
			curPage = Integer.parseInt( param ) ;
		}
		
		
		// 전체 게시글 수
		int totalCount = classDao.selectCntAll() ;
		
		// 페이징 객체 생성
		Paging paging = new Paging( totalCount , curPage ) ;
		System.out.println( paging ) ; //TEST
		
		return paging ;
	}

	@Override
	public DayClass getClassNum(HttpServletRequest req) {

		String param = req.getParameter( "classNum" ) ;
		
		int classNum= 0;
		
		if( param!=null && !"".equals(param) ) {
			classNum = Integer.parseInt(param);
		}
		
		
		DayClass dayclass = new DayClass();
		dayclass.setClassNum(classNum);
		
		return dayclass;
		
	}


	@Override
	public DayClass view(DayClass viewDayClass) {
		
		return classDao.selectDayClassByClassNum(viewDayClass);
	}

	
	
	}

	

