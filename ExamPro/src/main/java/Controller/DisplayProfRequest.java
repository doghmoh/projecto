package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import Dao.AdminFunction;

@WebServlet(name = "DisplayProfRequest", urlPatterns = {"/DisplayProfRequest"})
public class DisplayProfRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String id =  (String) session.getAttribute("id");
        if(id != null) {
      try {
          AdminFunction user = new AdminFunction();
          String data = user.GetNotCheckedProf();
          request.setAttribute("Prof", data);
          request.getRequestDispatcher("001/ManageProfRequest.jsp").forward(request, response);
      } catch (SQLException | ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) { 
      	response.sendRedirect("welcom.jsp");}        
  } 
	else response.sendRedirect("004/Signin/signin.jsp");
}}