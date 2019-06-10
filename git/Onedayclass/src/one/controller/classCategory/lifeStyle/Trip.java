package one.controller.classCategory.lifeStyle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/trip")
public class Trip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.getRequestDispatcher("/WEB-INF/views/classCategory/07_lifeStyle/Trip.jsp").forward(req, resp);
    	
    	
    }

}
 