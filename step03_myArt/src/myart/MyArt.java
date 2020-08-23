package myart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyArt")
public class MyArt extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Get");
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post");
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("newInfo", "Age : 45");
		//HttpSession session = request.getSession();
		//session.setAttribute("newInfo", "Age : 45");
		//session.setAttribute("reqPara", request.getParameter("Init"));
		request.getRequestDispatcher("Second").forward(request, response);
		//response.sendRedirect("Second");
	}
}
