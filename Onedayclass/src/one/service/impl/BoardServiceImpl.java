package one.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
	public List getList() {
		return boardDao.selectAll();
	}
	
	@Override
	public List getnoticeList() {
		return boardDao.selectnoticeAll();
	}

	@Override
	public List getbulletinList() {
		return boardDao.selectbulletinAll();
	}

	@Override
	public List getreportList() {
		return boardDao.selectreportAll();
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


	@Override
	public void write(HttpServletRequest req) {

		Board board = null;

		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		if (!isMultipart) {
			return;

		} else {
			// 파일업로드를 사용하고 있을 경우
			board = new Board();

			// 디스크팩토리
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 메모리처리 사이즈
			factory.setSizeThreshold(1 * 1024 * 1024); // 1MB

			// 임시 저장소
			File repository = new File(req.getServletContext().getRealPath("tmp"));
			factory.setRepository(repository);

			// 업로드 객체 생성
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 용량 제한 설정 : 10MB
			upload.setFileSizeMax(10 * 1024 * 1024);

			// form-data 추출
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);

			} catch (FileUploadException e) {
				e.printStackTrace();
			}

			// 파싱된 데이터 처리 반복자
			Iterator<FileItem> iter = items.iterator();

			// 요청정보 처리
			while (iter.hasNext()) {
				FileItem item = iter.next();

				// 빈 파일 처리
				if (item.getSize() <= 0)
					continue;

				// 빈 파일이 아닐 경우
				if (item.isFormField()) {

					try {

						// 제목 처리
						if ("title".equals(item.getFieldName())) {
							board.setTitle(item.getString("utf-8"));
						}

						// 본문 처리
						if ("content".equals(item.getFieldName())) {
							board.setContent(item.getString("utf-8"));
						}

					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

					String param = req.getParameter("userNum");
					int userNum = 0;
					if (param != null && !"".equals(param)) {
						userNum = Integer.parseInt(param);
					}

					// 작성자id 처리
					board.setUsernum(userNum);

				} else {
					UUID uuid = UUID.randomUUID();
//					System.out.println(uuid);

					String u = uuid.toString().split("-")[4];
//					System.out.println(u);
					// -----------------

					// 로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(req.getServletContext().getRealPath("upload"), stored);

					try {
						// 실제 업로드
						item.write(up);

						// 임시 파일 삭제
						item.delete();

					} catch (Exception e) {
						e.printStackTrace();
					} // try end
				} // if end
			} // while end
		} // if(!isMultipart) end

		int boardno = boardDao.selectBoardno();

		if (board != null) {
			board.setBoardno(boardno);

			if (board.getTitle() == null || "".equals(board.getTitle())) {
				board.setTitle("(제목없음)");

				String param = req.getParameter("userNum");
				int userNum = 0;
				if (param != null && !"".equals(param)) {
					userNum = Integer.parseInt(param);
				}

				// 작성자id 처리
				board.setUsernum(userNum);
			}

			boardDao.insert(board);
		}

	}
}
