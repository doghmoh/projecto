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

@WebServlet(name = "DisplayGroupMember", urlPatterns = {"/DisplayGroupMember"})
public class DisplayGroupMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String id = (String) session.getAttribute("id");
		String groupid = request.getParameter("objectid");
		try { 
			AdminFunction am = new AdminFunction();
		String data = am.GetStudentbyGroup(groupid);
		request.setAttribute("student", data);
		request.getRequestDispatcher("001/GroupMember.jsp").forward(request, response);
		} catch (SQLException | ParserConfigurationException | TransformerException | TransformerFactoryConfigurationError e) {
			request.setAttribute("message", e);
			request.getRequestDispatcher("welcom.jsp").forward(request, response);
		}
	}

}
