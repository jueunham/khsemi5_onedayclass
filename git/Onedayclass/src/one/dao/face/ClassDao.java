package one.dao.face;

import java.util.List;

import one.dto.DayClass;
import one.util.Paging;

public interface ClassDao {
	
	
	/**
	 * 테이블 전체 조회
	 * 
	 * @return 테이블 전체 조회 결과
	 */
	public List selectAll( Paging paging );
	/**
	 * 테이블 전체 COUNT 조회
	 * 
	 * @return 테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll();
	
	public DayClass selectDayClassByClassNum( DayClass dayclass );
	
	
	
	
					
}
