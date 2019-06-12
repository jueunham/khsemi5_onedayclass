package one.controller.mypage.host;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import one.dto.Member;
import one.dto.MemberFile;
import one.service.face.MemberService;
import one.service.impl.MemberServiceImpl;

@WebServlet("/mypage/host/upinfo")
public class HostInfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		//세션에 저장된 값 불러오기(가져오기)
		String userid = (String) session.getAttribute("userid");
//		System.out.println(userid);
		
		Member meminfo = new Member();
		meminfo.setUserid(userid);
		
		meminfo = memberService.getMemberByUserid(meminfo);		
		req.setAttribute("meminfo", meminfo);
//		System.out.println(meminfo);
		
		//첨부파일 전달
		MemberFile memberFile = memberService.viewFile(meminfo);
		req.setAttribute("memberFile", memberFile);
		
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/host/updateinfo.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		memberService.updateinfo(req);
		
		resp.sendRedirect("/mypage/host");
	
		
	}
}
