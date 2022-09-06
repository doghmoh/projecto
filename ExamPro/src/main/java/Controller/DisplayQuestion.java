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

@WebServlet(name = "DisplayQuestion", urlPatterns = {"/DisplayQuestion"})
public class DisplayQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
		HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
 		 try {
	            AdminFunction admin=new AdminFunction();
	            String data = admin.XmlToString(admin.GetQuestionData(id,"profid").getOwnerDocument(), admin.GetQuestionData(id,"profid"));
	            request.setAttribute("Question", data);
	            request.getRequestDispatcher("002/ManageQuestion.jsp").forward(request, response);
	           
	        } catch (SQLException | ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException  e) {request.setAttribute("message", e);
	        request.getRequestDispatcher("welcom.jsp").forward(request, response);;}        
	   
	}
	
}
