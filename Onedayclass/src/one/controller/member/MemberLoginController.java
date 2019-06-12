package one.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.Member;
import one.service.face.MemberService;
import one.service.impl.MemberServiceImpl;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//MemberService 媛앹껜
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//VIEW 吏��젙
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//濡쒓렇�씤 �젙蹂� �뼸�뼱�삤湲�
		Member member = memberService.getLoginMember(req);
		System.out.println(member);
		//濡쒓렇�씤 �씤利�
		boolean login = memberService.login(member);
		System.out.println(login);
		if(login) {
			
			Member loginMem = new Member();
			//濡쒓렇�씤 �궗�슜�옄 �젙蹂� �뼸�뼱�삤湲�
			loginMem = memberService.getMemberByUserid(member);
			
			//�꽭�뀡�젙蹂� ���옣
			req.getSession().setAttribute("login", login);
			req.getSession().setAttribute("userid", loginMem.getUserid());
			req.getSession().setAttribute("usernum", loginMem.getUsernum());
			System.out.println(loginMem.getUsernum());
		}
		
		resp.sendRedirect("/main");
		
	}
	
}
