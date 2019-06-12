package one.dao.face;

import java.util.List;

import one.dto.Board;
import one.util.Paging;
import one.dto.BoardFile;
import one.dto.Bulletin_Comment;
import one.dto.Member;

public interface BoardDao {

	/**
	 * 테이블 전체 조회
	 * 
	 * @param paging - 조회대상 페이징 객체
	 * @return 테이블 전체 조회 결과
	 */
	public List selectbulletinAll(Paging paging);
	
	public List selectnoticeAll(Paging paging);
	
	public List selectreportAll(Paging paging);
	
	/**
	 * 테이블 전체 COUNT 조회
	 * 
	 * @return 테이블 전체 행 수 조회 결과
	 */
	public int selectCntAll();
	
	/**
	 * 조회되는 게시글의 조회수 +1
	 * 
	 * @param viewBoard - 조회 대상
	 */
	public void updateHit(Board viewBoard);

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
	public void bulletininsert(Board board);
	
	/**
	 * 게시글 입력
	 * 
	 * @param board - 삽입될 게시글 내용
	 */
	public void noticeinsert(Board board);
	
	/**
	 * 게시글 입력
	 * 
	 * @param board - 삽입될 게시글 내용
	 */
	public void reportinsert(Board board);
	
	/**
	 * 첨부파일 입력
	 * 
	 * @param boardFile - 업로드 된 첨부파일 내용
	 */
	public void insertFile(BoardFile boardFile);
	
	/**
	 * 첨부파일 조회
	 * 
	 * @param board - 첨부파일을 조회할 게시글 객체
	 * @return BoardFile - 조회된 첨부파일
	 */
	public BoardFile selectFile(Board board);
	
	/**
	 * 파일번호로 첨부파일 정보 조회
	 * 
	 * @param fileno - 조회할 첨부파일의 번호
	 * @return BoardFile - 조회된 첨부파일
	 */
	public BoardFile selectByFileno(int fileno);

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
	 * 게시글에 첨부된 파일 기록 삭제
	 * 
	 * @param board - 삭제할 게시글번호를 담은 객체
	 */
	public void deleteFile(Board board);

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

