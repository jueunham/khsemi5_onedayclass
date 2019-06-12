package one.controller.mypage.host;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import one.dto.DayClass;
import one.service.face.ClassService;
import one.service.impl.ClassServiceImpl;
import one.util.Paging;

@WebServlet("/mypage/host/upclass")
public class HostClassUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClassService classService = new ClassServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//curpage얻어오기
		Paging paging = classService.getCurPage(req);
		
		//Paging 객체 넣기
		req.setAttribute("Paging", paging);
		
		//클래스 리스트 조회
		List myclasslist = classService.getList(paging);
		
		
		req.setAttribute("myclasslist", myclasslist);
		
		HttpSession session = req.getSession();
		int usernum = (int) session.getAttribute("usernum");
		req.setAttribute("usernum", usernum);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/host/updateclass.jsp").forward(req, resp);
	}
}
