package one.dao.face;

import java.util.List;

public interface BannerDao {
	/**
	 * Board테이블 전체 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블 전체 조회 결과
	 */
	public List selectAll();
}
