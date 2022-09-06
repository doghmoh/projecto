/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


@WebServlet(name = "AdminPanelServlet", urlPatterns = {"/AdminPanelServlet"})
public class AdminPanelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          HttpSession session = request.getSession();
          String id =  (String) session.getAttribute("id");
          if(id != null) {
        try {
        	AdminFunction user = new AdminFunction();
            String data1 = user.GetNotCheckedAdmin();
            String data2 = user.GetNotCheckedProf();
            request.setAttribute("Admin", data1);
            request.setAttribute("Prof", data2);
            request.getRequestDispatcher("002/ManageExam.jsp").forward(request, response);
        } catch (SQLException | ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) { 
        	response.sendRedirect("welcom.jsp");}        
    } 
	else response.sendRedirect("004/Signin/signin.jsp");
}}
