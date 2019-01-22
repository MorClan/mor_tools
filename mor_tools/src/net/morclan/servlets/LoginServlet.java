package net.morclan.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.morclan.eao.UsersEAO;
import net.morclan.utils.LoginUtils;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int timeout;
	
	@EJB
	private UsersEAO userEAO;
	
	@Override
	public void init() throws ServletException {
		timeout = Integer.parseInt(getServletContext().getInitParameter("timeout"));		
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginBeskjed = LoginUtils.loginOverskrift(request);
		request.setAttribute("loginError", loginBeskjed);
		
		request.getRequestDispatcher("WEB-INF/JSP/Login.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(LoginUtils.loggInn(request,timeout, userEAO)) {
			response.sendRedirect("MainServlet");
		}else {
			response.sendRedirect("LoginServlet?feilPassord");
		}
	}

}
