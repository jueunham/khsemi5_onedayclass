package one.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.service.face.MemberService;
import one.service.impl.MemberServiceImpl;


@WebServlet("/admin/member")
public class MemberManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 //memberService 객체
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//회원 목록 조회
		List list = memberService.getList();
		
		//MODEL로 조회 결과 넣기
		req.setAttribute("memlist", list);
		
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/manager/memberManage.jsp").forward(req, resp);
	}

}
