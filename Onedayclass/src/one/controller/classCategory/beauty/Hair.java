package one.controller.classCategory.beauty;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hair")
public class Hair extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	   req.getRequestDispatcher("/WEB-INF/views/classCategory/03_beauty/Hair.jsp").forward(req, resp);
	   
   }

}