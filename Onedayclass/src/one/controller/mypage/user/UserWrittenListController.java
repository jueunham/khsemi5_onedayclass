package one.controller.mypage.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.service.face.BoardService;
import one.service.face.MypageService;
import one.service.impl.BoardServiceImpl;
import one.service.impl.MypageServiceImpl;
import one.util.Paging;

@WebServlet("/mypage/user/written")
public class UserWrittenListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MypageService mypageService = new MypageServiceImpl();
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Paging paging = boardService.getCurPage(req);
		
		List<Map<String, Object>> list = mypageService.getRevQue();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/user/writtenlist.jsp").forward(req, resp);
		
	}
}
