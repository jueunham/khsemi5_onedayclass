package one.controller.mypage.user;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.service.face.MypageService;
import one.service.impl.MypageServiceImpl;

@WebServlet("/mypage/user/myclass")
public class UserMyclassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MypageService mypageService = new MypageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Map<String, Object>> list = mypageService.getList();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/user/myclass.jsp").forward(req, resp);
		
	}
	
}
