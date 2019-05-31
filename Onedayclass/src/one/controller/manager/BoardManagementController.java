package one.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardManagementController
 */
@WebServlet("/admin/board")
public class BoardManagementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		//VIEW 지정
		req.getRequestDispatcher("/WEB-INF/views/manager/boardManage.jsp").forward(req, resp);
	}
}
