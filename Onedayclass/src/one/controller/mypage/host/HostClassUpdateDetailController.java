package one.controller.mypage.host;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import one.dto.ClassFile;
import one.dto.DayClass;
import one.service.face.ClassService;
import one.service.impl.ClassServiceImpl;

@WebServlet("/mypage/host/upclassdetail")
public class HostClassUpdateDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassService classService = new ClassServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//클래스 번호 파싱
		DayClass viewDayclass = classService.getClassnum(req);
		
		//클래스 조회
		viewDayclass = classService.view(viewDayclass);
		
		//model로 클래스 전달
		req.setAttribute("viewDayclass", viewDayclass);
		
		//첨부파일 전달
		ClassFile classFile = classService.viewFile(viewDayclass);
		req.setAttribute("classFile", classFile);
		
		req.getRequestDispatcher("/WEB-INF/views/mypage/host/updateclassDetail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//수정클래스 삽입
		req.setCharacterEncoding("utf-8");
		classService.updateClass(req);
		
		//클래스목록으로 리다이렉션
		resp.sendRedirect("/mypage/host/upclass");
		
	}

}
