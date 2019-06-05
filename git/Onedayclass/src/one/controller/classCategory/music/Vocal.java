package one.controller.classCategory.music;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vocal
 */
@WebServlet("/vocal")
public class Vocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
    		req.getRequestDispatcher("/WEB-INF/views/classCategory/06_music/Vocal.jsp").forward(req, resp);
    	
    	}

}
 