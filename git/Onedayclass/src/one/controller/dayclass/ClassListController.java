package one.controller.dayclass;

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




/**
 * Servlet implementation class ClassListController
 */
@WebServlet("/classlist")
public class ClassListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClassService classService = new ClassServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청파라미터에서 curPage 얻어오기
		Paging paging = classService.getCurPage( req ) ;
		
		// MODEL로 Paging 객체 넣기
		req.setAttribute( "paging" , paging ) ; 
		
		//게시판 목록 조회
		List list = classService.getList( paging ) ;
		
		//MODEL로 조회 결과 넣기
		req.setAttribute("classlist", list);
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/class/list.jsp").forward(req, resp);
		}
	
	 
	
}
