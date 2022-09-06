/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AdminFunction;
import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "GetExamServlet", urlPatterns = {"/GetExamServlet"})
public class GetExamServlet extends HttpServlet {

    
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		HttpSession session =request.getSession();
		String id = (String)session.getAttribute("id");
		String exam = request.getParameter("examid");
		 
        AdminFunction adminfunction;
		try {
			adminfunction = new AdminFunction();
			String data =adminfunction.GetExamPaper (exam,"id");
			   request.setAttribute("Question",data);
	           request.getRequestDispatcher("002/ViewExamPaper.jsp").forward(request, response); 
       } catch (SQLException | ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
    	   request.setAttribute("message", e);
    	   request.getRequestDispatcher("welcom.jsp").forward(request, response);
		}
}
}