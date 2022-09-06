package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import Dao.AdminFunction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "DisplayModule", urlPatterns = {"/DisplayModule"})
public class DisplayModule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
       if(id == null) {
    	 id = (String) request.getAttribute("id");
       }
        try {
        AdminFunction adminfunction= new AdminFunction();
		request.setAttribute("module", adminfunction.GetModuleData(id));
		request.setAttribute("speciality", adminfunction.GetSpeciality(id));
		request.getRequestDispatcher("001/ManageModule.jsp").forward(request, response);
		}catch (SQLException | ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			request.setAttribute("message", e);
			request.getRequestDispatcher("welcom.jsp").forward(request, response);
		}
	}
}
