package one.controller.mypage.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.Board;
import one.dto.Member;
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
		
		//후기, 질문 리스트 조회
		List<Map<String, Object>> reviewList = mypageService.getReview();
		req.setAttribute("reviewList", reviewList);
//		System.out.println(reviewList);
		
		List<Map<String, Object>> quesList = mypageService.getQuestion();
		req.setAttribute("quesList", quesList);
//		System.out.println(quesList);
		
		//user mypage 게시글 가져오기
		Paging paging = boardService.getCurPage(req);
		
		req.setAttribute("paging", paging);
		
		Member member = new Member();
		String userid = req.getParameter("userid");
		
		//게시판 목록 조회
//		if(mypageService.getCntuserid(req) != null) {
		if(mypageService.getUserid(userid) == null) {
			
			System.out.println("false");
			
		} else if(mypageService.getUserid(userid) != null
				&& mypageService.getUserid(userid).equals(member.getUserid())){					
			List boardList = boardService.getList(paging);
			
			req.setAttribute("boardList", boardList);
			
			//TEST
			System.out.println("true");
			System.out.println(boardList);
		}
				
		req.getRequestDispatcher("/WEB-INF/views/mypage/user/writtenlist.jsp").forward(req, resp);
		
	}
}
