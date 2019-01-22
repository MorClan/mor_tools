package net.morclan.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.morclan.eao.DeathsEAO;
import net.morclan.eao.KillsEAO;
import net.morclan.enteties.Death;
import net.morclan.enteties.Kill;
import net.morclan.utils.LoginUtils;
import net.morclan.utils.MathUtil;

/**
 * Servlet implementation class mainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	KillsEAO kEAO;
	
	@EJB
	DeathsEAO dEAO;
	
	List<Kill> kList;
	List<Death> dList;
	String kdr;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!LoginUtils.brukerErInnlogget(request)) {
			response.sendRedirect("LoginServlet?trengerLogin");
		} else {
			kList=kEAO.getAll();
			dList=dEAO.getAll();
			int k=kList.size();
			int d=dList.size();
			if(d==0) {
				d=1;
			}
			String kdr=MathUtil.calcKDR(k,d);
			request.setAttribute("kdr", kdr);
			request.getRequestDispatcher("WEB-INF/JSP/home.jsp").forward(request, response);
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
