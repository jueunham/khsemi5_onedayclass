package one.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dao.face.BoardDao;
import one.dao.impl.BoardDaoImpl;
import one.dto.Board;
import one.service.face.BoardService;
import one.util.Paging;

public class BoardServiceImpl implements BoardService {

	// BoardDao 객체
	private BoardDao boardDao = new BoardDaoImpl();

	@Override
	public Board getBoardno(HttpServletRequest req) {

		// 전달파라미터 boardno 파싱
		String param = req.getParameter("boardno");
		int boardno = 0;
		if (param != null && !"".equals(param)) {
			boardno = Integer.parseInt(param);
		}

		// Board 객체 생성
		Board board = new Board();
		board.setBoardno(boardno);

		return board;
	}

	@Override
	public Board view(Board viewBoard) {

		// 게시글 조회 반환
		return boardDao.selectBoardByBoardno(viewBoard);
	}

	@Override
	public void update(HttpServletRequest req) {
		Board board = null;

		board = new Board();

		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));

//		System.out.println(board);
//		System.out.println(boardFile);

		if (board != null) {
			boardDao.update(board);
		}
	}

	@Override
	public void delete(Board board) {

		boardDao.delete(board);

	}

	@Override
	public boolean checkWriter(HttpServletRequest req) {

		// 로그인한 세션 ID 얻기
		String loginId = (String) req.getSession().getAttribute("userid");

		// 작성한 게시글 번호 얻기
		Board board = getBoardno(req);

		// 게시글 얻어오기
		board = boardDao.selectBoardByBoardno(board);

		// 게시글의 작성자와 로그인 아이디 비교
		if (!loginId.equals(board.getUsernum())) {
			return false;
		}

		return true;
	}

	@Override
	public List getList(Paging paging) {
		return boardDao.selectAll();
	}

	@Override
	public Paging getCurPage(HttpServletRequest req) {
		// 전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 전체 게시글 수
		int totalCount = boardDao.selectCntAll();

		// 페이징 객체 생성
		Paging paging = new Paging(totalCount, curPage);
//				System.out.println(paging); //TEST

		return paging;
	}
}
