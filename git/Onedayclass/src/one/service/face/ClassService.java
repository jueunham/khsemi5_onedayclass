package one.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dto.DayClass;
import one.util.Paging;


public interface ClassService {

	/**
	 * 게시글 리스트 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 게시글을 조회한 결과
	 */
	public List getList( Paging paging );
	
	/**
	 * 요청파라미터에서 curPage를 파싱함
	 * 
	 * @param req - 요청정보객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getCurPage( HttpServletRequest req );
	
	public DayClass getClassNum( HttpServletRequest req ) ;
	
	public DayClass view(DayClass viewDayClass);
	

}
