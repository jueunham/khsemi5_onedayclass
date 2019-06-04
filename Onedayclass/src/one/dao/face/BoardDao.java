package one.dao.face;

import java.util.List;

import one.dto.Board;

public interface BoardDao {

	/**
	 * 테이블 전체 조회
	 * 
	 * 
	 * @return 테이블 전체 조회 결과
	 */
	public List selectAll();
	
	/**
	 * 공지사항 게시글 조회
	 * 
	 * 
	 * @return 공지사항  조회 결과
	 */
	public List selectnoticeAll();

	/**
	 * 자유게시판 게시글 조회
	 * 
	 * 
	 * @return 자유게시판조회 결과
	 */
	public List selectbulletinAll();

	/**
	 * 신고게시판 게시글 조회
	 * 
	 * 
	 * @return 신고게시판 조회 결과
	 */
	public List selectreportAll();
}
