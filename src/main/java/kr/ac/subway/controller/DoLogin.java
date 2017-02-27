package kr.ac.subway.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String page;
		
		if(id.equals("admin") && password.equals("1234"))
		{
			SubwayController.flag=true;
			System.out.println(id);
			System.out.println(password);
			request.setAttribute("id", id);
			page="/WEB-INF/views/loginsuccess.jsp";
		}
		else if(  ((!(id.equals("admin"))) && password.equals("1234")) || (id.equals("admin")) && (!password.equals("1234")))
		{
			page="/WEB-INF/views/loginmistake.jsp";
		}
		else
			page="/WEB-INF/views/loginfailed.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}
