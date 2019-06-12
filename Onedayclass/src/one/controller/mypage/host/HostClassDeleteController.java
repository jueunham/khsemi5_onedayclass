package one.controller.mypage.host;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.DayClass;
import one.service.face.ClassService;
import one.service.impl.ClassServiceImpl;

@WebServlet("/mypage/host/deleteclass")
public class HostClassDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClassService classService = new ClassServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DayClass dayClass = classService.getClassnum(req);
		
		classService.delete(dayClass);
		
		//리다이렉트
		resp.sendRedirect("/mypage/host/upclass");
		
	}
}
