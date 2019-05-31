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


@WebServlet("/admin/class")
public class ClassManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//classService 객체
	private ClassService classService = new ClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//클래스 목록조회
		List list = classService.getList();
				
		//MODEL로 조회 결과 넣기
		req.setAttribute("classlist", list);
		
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/manager/classManage.jsp").forward(req, resp);
	}
}
