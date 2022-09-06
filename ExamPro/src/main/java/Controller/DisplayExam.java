package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import Dao.AdminFunction;

@WebServlet(name = "DisplayExam", urlPatterns = {"/DisplayExam"})
public class DisplayExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

	     
	            AdminFunction adminfunction;
				try {
					adminfunction = new AdminFunction();
					String data1 = adminfunction.GetProfQuesion(id);
					String data2 = adminfunction.GetExamPaper(id,"profid");
                    request.setAttribute("Question", data1);
		            request.setAttribute("Exam", data2);
		            request.getRequestDispatcher("002/ManageExam.jsp").forward(request, response);
	           } catch (SQLException | ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
	        	   request.setAttribute("message", e);
	        	   request.getRequestDispatcher("welcom.jsp").forward(request, response);
				}
	       
	        }        
}
