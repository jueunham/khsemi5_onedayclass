package one.controller.mypage.host;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.service.face.ClassService;
import one.service.impl.ClassServiceImpl;

@WebServlet("/mypage/host/upload")
public class HostClassUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClassService classService = new ClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/mypage/host/uploadclass.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//클래스 삽입
		classService.uploadClass(req);
		
		//목록으로 리다이렉션
		resp.sendRedirect("/mypage/host");
		
	}
	
}
