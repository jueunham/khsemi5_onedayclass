package one.controller.classCategory.investmentTechniques;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/virtualmoney")
public class VirtualMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.getRequestDispatcher("/WEB-INF/views/classCategory/08_investmentTechniques/VirtualMoney.jsp").forward(req, resp);
    	
    }
    

}
