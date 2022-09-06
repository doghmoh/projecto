/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.io.IOException;

import Dao.AdminFunction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "DisplayMark", urlPatterns = {"/DisplayMark"})
public class DisplayMark extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{

		HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
		
	            AdminFunction adminfunction;
				
				try {
					request.getRequestDispatcher("002/ManageMark.jsp").forward(request, response);
				} catch (ServletException | IOException e) {
				}
	          
	       
	        }        
}
