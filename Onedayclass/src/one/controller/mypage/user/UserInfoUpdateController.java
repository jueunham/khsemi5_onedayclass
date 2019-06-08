package one.controller.mypage.user;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import one.dto.Member;
import one.service.face.MypageService;
import one.service.impl.MypageServiceImpl;

@WebServlet("/mypage/user/upinfo")
public class UserInfoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		//세션에 저장된 값 불러오기(가져오기)
		String userid = (String) session.getAttribute("userid");
		
		Member member = mypageService.getUserNum(req);
		
		member = mypageService.view(member);
		
		req.setAttribute("member", member);
		
//		if(userid == null) {
//			resp.sendRedirect("/main");
//		} else {
			req.getRequestDispatcher("/WEB-INF/views/mypage/user/updateinfo.jsp").forward(req, resp);
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		
		mypageService.updateInfo(req);
		
		String[] CheckBoxInputName = req.getParameterValues("CheckBoxInputName");
		List list = Arrays.asList(CheckBoxInputName);
		req.setAttribute("CheckBoxInputName", list);
		System.out.println(list);
		
		resp.sendRedirect("/mypage/member");
		
	}

}
