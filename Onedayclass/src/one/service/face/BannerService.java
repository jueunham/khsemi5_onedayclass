package one.service.face;

import java.util.List;

public interface BannerService {
	/**
	 * 게시글 리스트 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 게시글을 조회한 결과
	 */
	public List getList();

}
