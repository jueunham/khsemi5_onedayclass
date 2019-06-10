package one.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.service.face.ClassService;
import one.service.impl.ClassServiceImpl;
import one.util.Paging;

@WebServlet("/admin/banner")
public class BannerManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//ClassService 객체
	private ClassService classService = new ClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//curpage얻어오기
		Paging paging = classService.getCurPage(req);
						
		//Paging 객체 넣기
		req.setAttribute("Paging", paging);
		
		//클래스 목록조회
		List list = classService.getList(paging);

		// MODEL로 조회 결과 넣기
		req.setAttribute("classlist", list);

		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/manager/bannerManage.jsp").forward(req, resp);
     	}
}
