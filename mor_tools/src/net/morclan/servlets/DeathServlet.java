package net.morclan.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.morclan.beans.KillsDeathsValidation;
import net.morclan.eao.DeathsEAO;
import net.morclan.enteties.Death;
import net.morclan.enteties.Kill;
import net.morclan.utils.LoginUtils;
import net.morclan.utils.TownNames;



/**
 * Servlet implementation class DeathServlet
 */
@WebServlet("/DeathServlet")
public class DeathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private DeathsEAO dEAO;
	private List<Death> dlist;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!LoginUtils.brukerErInnlogget(request)) {
			response.sendRedirect("LoginServlet?trengerLogin");
		} else {
			dlist=dEAO.getAll();
			List<String> locations=Arrays.asList(TownNames.getTownNames());
			request.setAttribute("Locations", locations);
			request.setAttribute("dlist", dlist);
			request.getRequestDispatcher("WEB-INF/JSP/Deaths.jsp").forward(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KillsDeathsValidation skjema=new KillsDeathsValidation(request,dEAO);
		if(skjema.isAltGyldig()) {
			Death add=skjema.createDeath();
			dEAO.add(add);
		}
		response.sendRedirect("DeathServlet");
		
	}

}
