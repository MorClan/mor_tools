package net.morclan.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.morclan.beans.Skjema;
import net.morclan.eao.UsersEAO;
import net.morclan.enteties.User;
import net.morclan.utils.LoginUtils;

/**
 * Servlet implementation class RegisterSerlvet
 */
@WebServlet("/RegisterSerlvet")
public class RegisterSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private UsersEAO userEAO;
	
	private int timeout;
	
	@Override
	public void init() throws ServletException {
		timeout = Integer.parseInt(getServletContext().getInitParameter("timeout"));

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/JSP/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Skjema skjema = new Skjema(request, userEAO);
		
		
		
		
		if(skjema.isAltGyldig()) {
			request.getSession().removeAttribute("skjema");
			
			User user = skjema.createUser();
			userEAO.addUser(user);
			LoginUtils.sessionStart(request, user, timeout);
			request.setAttribute("bekreftet", user);
			
			request.getRequestDispatcher("WEB-INF/JSP/confirm.jsp").forward(request, response);
		} else {
			skjema.setupFeilMeldinger();
			request.getSession().setAttribute("skjema", skjema);
			response.sendRedirect("RegisterSerlvet");
		}	
		
	}

}
