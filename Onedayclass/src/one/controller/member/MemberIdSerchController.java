package one.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.service.face.MemberService;
import one.service.impl.MemberServiceImpl;

@WebServlet("/member/idserch")
public class MemberIdSerchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//BoardService 객체
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//VIEW지정
		req.getRequestDispatcher("/WEB-INF/views/member/idSearch.jsp").forward(req, resp);
	}
}
