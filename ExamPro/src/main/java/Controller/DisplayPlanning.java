package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import Dao.AdminFunction;
import Model.Database;

@WebServlet(name = "DisplayPlanning", urlPatterns = {"/DisplayPlanning"})
public class DisplayPlanning extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		String id = (String)session.getAttribute("id");
		AdminFunction adminfunction;
		
		try {
			adminfunction = new AdminFunction();
		    request.setAttribute("Exam",adminfunction.GetPlanningData());
            request.getRequestDispatcher("003/ExamPlanning.jsp").forward(request, response);
            }catch (SQLException | TransformerException | ParserConfigurationException e) {
	    	   request.setAttribute("message", e);
	    	   request.getRequestDispatcher("welcom.jsp").forward(request, response);
		    } 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
