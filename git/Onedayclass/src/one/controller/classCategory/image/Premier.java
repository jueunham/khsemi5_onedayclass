package one.controller.classCategory.image;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/premier")
public class Premier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/classCategory/04_image/Premier.jsp").forward(req, resp);
		
	}
	
	

}
