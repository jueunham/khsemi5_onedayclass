package one.controller.classCategory.foreignLanguage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TOEIC_TOEFL
 */
@WebServlet("/toeic_toefl")
public class TOEIC_TOEFL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.getRequestDispatcher("/WEB-INF/views/classCategory/05_foreignLanguage/TOEIC_TOEFL.jsp").forward(req, resp);
    	
    }
     

}
