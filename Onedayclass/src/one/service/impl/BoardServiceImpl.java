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
import one.dao.face.CommentDao;
import one.dao.impl.BoardDaoImpl;
import one.dao.impl.CommentDaoImpl;
import one.dto.Board;
import one.service.face.BoardService;
import one.service.face.MemberService;
import one.util.Paging;
import one.dto.BoardFile;
import one.dto.Bulletin_Comment;

public class BoardServiceImpl implements BoardService {

	// BoardDao 객체
	private BoardDao boardDao = new BoardDaoImpl();
	private CommentDao commentDao = new CommentDaoImpl();
	private MemberService memberService = new MemberServiceImpl();

	@Override
	public List getnoticeList(Paging paging) {
		return boardDao.selectnoticeAll(paging);
	}

	@Override
	public List getbulletinList(Paging paging) {
		return boardDao.selectbulletinAll(paging);
	}

	@Override
	public List getreportList(Paging paging) {
		return boardDao.selectreportAll(paging);
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
//		System.out.println(paging); //TEST

		return paging;
	}

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

		// 게시글 조회수 +1
		boardDao.updateHit(viewBoard);

		// 게시글 조회 반환
		return boardDao.selectBoardByBoardno(viewBoard);
	}

	@Override
	public void BulletinWrite(HttpServletRequest req) {

		Board board = null;
		BoardFile boardFile = null;

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

					board.setUserid((String) req.getSession().getAttribute("userid)"));

				} else {
					UUID uuid = UUID.randomUUID();
//						System.out.println(uuid);

					String u = uuid.toString().split("-")[4];
//						System.out.println(u);
					// -----------------

					// 로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(req.getServletContext().getRealPath("upload"), stored);

					boardFile = new BoardFile();
					boardFile.setOriginName(item.getName());
					boardFile.setStoredName(stored);
					boardFile.setFilesize(item.getSize());

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

		// 세션에서 userid 꺼내기
		board.setUserid((String) req.getSession().getAttribute("userid"));

		if (board != null) {
			board.setBoardno(boardno);

			if (board.getTitle() == null || "".equals(board.getTitle())) {
				board.setTitle("(제목없음)");

				board.setUserid((String) req.getSession().getAttribute("userid)"));

			}
			boardDao.bulletininsert(board);
		}

		if (boardFile != null) {
			boardFile.setBoardno(boardno);
			System.out.println(boardFile);
			boardDao.insertFile(boardFile);
		}
	}

	@Override
	public void NoticeWrite(HttpServletRequest req) {

		Board board = null;
		BoardFile boardFile = null;

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

					board.setUserid((String) req.getSession().getAttribute("userid)"));

				} else {
					UUID uuid = UUID.randomUUID();
//						System.out.println(uuid);

					String u = uuid.toString().split("-")[4];
//						System.out.println(u);
					// -----------------

					// 로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(req.getServletContext().getRealPath("upload"), stored);

					boardFile = new BoardFile();
					boardFile.setOriginName(item.getName());
					boardFile.setStoredName(stored);
					boardFile.setFilesize(item.getSize());

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

		// 세션에서 userid 꺼내기
		board.setUserid((String) req.getSession().getAttribute("userid"));

		if (board != null) {
			board.setBoardno(boardno);

			if (board.getTitle() == null || "".equals(board.getTitle())) {
				board.setTitle("(제목없음)");

				board.setUserid((String) req.getSession().getAttribute("userid)"));

			}
			boardDao.bulletininsert(board);
		}

		if (boardFile != null) {
			boardFile.setBoardno(boardno);
			System.out.println(boardFile);
			boardDao.insertFile(boardFile);
		}
	}

	@Override
	public void ReportWrite(HttpServletRequest req) {

		Board board = null;
		BoardFile boardFile = null;

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

					board.setUserid((String) req.getSession().getAttribute("userid)"));

				} else {
					UUID uuid = UUID.randomUUID();
//						System.out.println(uuid);

					String u = uuid.toString().split("-")[4];
//						System.out.println(u);
					// -----------------

					// 로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(req.getServletContext().getRealPath("upload"), stored);

					boardFile = new BoardFile();
					boardFile.setOriginName(item.getName());
					boardFile.setStoredName(stored);
					boardFile.setFilesize(item.getSize());

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
		
		//세션에서 userid 꺼내기
		board.setUserid((String)req.getSession().getAttribute("userid"));
		
		if (board != null) {
			board.setBoardno(boardno);

			if (board.getTitle() == null || "".equals(board.getTitle())) {
				board.setTitle("(제목없음)");

				board.setUserid((String) req.getSession().getAttribute("userid)"));
				
			}
			boardDao.reportinsert(board);
		}

		if (boardFile != null) {
			boardFile.setBoardno(boardno);
			System.out.println(boardFile);
			boardDao.insertFile(boardFile);
		}
	}

	@Override
	public BoardFile viewFile(Board board) {
		return boardDao.selectFile(board);
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
		if (!loginId.equals(board.getUserid())) {
			return false;
		}

		return true;
	}

	@Override
	public void update(HttpServletRequest req) {
		Board board = null;
		BoardFile boardFile = null;

		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		if (!isMultipart) {
			// 파일 첨부가 없을 경우
			board = new Board();

			board.setTitle(req.getParameter("title"));
			board.setUserid((String) req.getSession().getAttribute("userid"));
			board.setContent(req.getParameter("content"));

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
						if ("boardno".equals(item.getFieldName())) {
							board.setBoardno(Integer.parseInt(item.getString()));
						}

						if ("title".equals(item.getFieldName())) {
							board.setTitle(item.getString("utf-8"));
						}
						if ("content".equals(item.getFieldName())) {
							board.setContent(item.getString("utf-8"));
						}

						board.setUserid((String) req.getSession().getAttribute("userid"));
					} catch (UnsupportedEncodingException e) {

						e.printStackTrace();
					}

				} else {
					UUID uuid = UUID.randomUUID();
//					System.out.println(uuid);

					String u = uuid.toString().split("-")[4];
//					System.out.println(u);
					// -----------------

					// 로컬 저장소 파일
					String stored = item.getName() + "_" + u;
					File up = new File(req.getServletContext().getRealPath("upload"), stored);

					boardFile = new BoardFile();
					boardFile.setOriginName(item.getName());
					boardFile.setStoredName(stored);
					boardFile.setFilesize(item.getSize());

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

//		System.out.println(board);
//		System.out.println(boardFile);

//		board.setTitle(req.getParameter("title"));
//		board.setContent(req.getParameter("content"));

//		System.out.println(board);
//		System.out.println(boardFile);

		if (board != null) {
			boardDao.update(board);
		}

		if(boardFile != null) {
			boardFile.setBoardno(board.getBoardno());
			boardDao.insertFile(boardFile);
		}
	}

	public void delete(Board board) {

		boardDao.deleteFile(board);

		boardDao.delete(board);

	}

	@Override
	public void boardListDelete(String names) {
		boardDao.deleteBoardFileList(names);
		boardDao.deleteBoardList(names);

	}

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getCommentList(Board viewBoard) {
	      return commentDao.selectComment(viewBoard);
	}

	@Override
	public Bulletin_Comment getComment(HttpServletRequest req) {
		try {
	         req.setCharacterEncoding("UTF-8");
	      } catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	      }
	      
	      String boardNo = (String) req.getParameter("boardno");
	      String userid = (String) req.getParameter("userid");
	      String content = (String) req.getParameter("content");
	      
	      Bulletin_Comment comment = new Bulletin_Comment();
	      comment.setBoardno( Integer.parseInt(boardNo) );
	      comment.setUserid(userid);
	      comment.setContent(content);
	      
	      return comment;

	}

	@Override
	public void insertComment(Bulletin_Comment comment) {
		commentDao.insertComment(comment);
		
	}

	@Override
	public boolean deleteComment(Bulletin_Comment comment) {
		commentDao.deleteComment(comment);
	      
	      if( commentDao.countComment(comment) > 0) {
	         return false;
	      } else {
	         return true;
	      }

	}
}
