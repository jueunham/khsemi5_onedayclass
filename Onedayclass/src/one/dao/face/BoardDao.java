package one.dao.face;

import java.util.List;

import one.dto.Board;
import one.util.Paging;

public interface BoardDao {

	/**
	 * 상세보기 게시글 조회
	 * 
	 * @param viewBoard - 조회 대상
	 * @return Board - 게시글 조회 결과
	 */
	public Board selectBoardByBoardno(Board viewBoard);

	/**
	 * 다음 게시글 번호 반환 게시글 테이블과 첨부파일 테이블에 들어갈 게시글 번호를 미리 추출
	 * 
	 * @return int
	 */
	public int selectBoardno();

	/**
	 * 게시글 입력
	 * 
	 * @param board - 삽입될 게시글 내용
	 */
	public void insert(Board board);

	/**
	 * 게시글 수정
	 * 
	 * @param board - 수정할 내용을 담은 객체
	 */
	public void update(Board board);

	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글번호를 담은 객체
	 */
	public void delete(Board board);

	/**
	 * 테이블 전체 COUNT 조회
	 * 
	 * @return 테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll();

	
	/**
	 * Board테이블 전체 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블 전체 조회 결과
	 */
	public List selectAll();
	/**
	 * Board테이블 공지사항 튜플 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블  조회 결과
	 */
	public List selectnoticeAll();
	/**
	 * Board테이블 자유게시판 튜플 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블  조회 결과
	 */
	public List selectbulletinAll();
	/**
	 * Board테이블 신고게시판 튜플 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블  조회 결과
	 */
	public List selectreportAll();

	/**
	 * 리스트에서 게시글의 첨부파일 삭제하기
	 * 
	 * @param names - 삭제한 게시글 번호 목록들 문자열
	 */
	public void deleteBoardFileList(String names);
	
	/**
	 * 리스트에서 게시글 삭제하기
	 * 
	 * @param names - 삭제한 게시글 번호 목록들 문자열
	 */
	public void deleteBoardList(String names);

}
