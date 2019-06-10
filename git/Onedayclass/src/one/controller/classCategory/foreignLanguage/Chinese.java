package one.controller.classCategory.foreignLanguage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chinese
 */
@WebServlet("/chinese")
public class Chinese extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/classCategory/05_foreignLanguage/Chinese.jsp").forward(req, resp);
		
	}

}
 