package one.controller.manager.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.service.face.BoardService;
import one.service.impl.BoardServiceImpl;


@WebServlet("/admin/board/notice/write")
public class BoardNoticeWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//BoardService 객체
		private BoardService boardService = new BoardServiceImpl();

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//VIEW 지정
			req.getRequestDispatcher("/WEB-INF/views/manager/boardManage/noticeWrite.jsp")
				.forward(req, resp);
			
		}
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			//작성글 삽입
			boardService.NoticeWrite(req);
			
			//목록으로 리다이렉션
			resp.sendRedirect("/admin/board/notice/list");
			
		}
}
