package net.morclan.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.morclan.eao.UsersEAO;
import net.morclan.enteties.User;



/**
 * Hjelpeklasse for inlogging
 * 
 * 
 * @author Gruppe 22
 */
public class LoginUtils {
	/**
	 * Klasse for � bestemme overskrift p� inlogging
	 * 
	 * @param request fra servlet
	 * @return feilmelding/overskrift i inloggingskjerm
	 */
	public static String loginOverskrift(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String beOmPassord = "";
		
		String feilPassord = request.getParameter("feilPassord");
		
		if(feilPassord != null){
			//Hvis bruker ble redirected tilbake på grunn av feil passord
			beOmPassord = "Error, invalid username and/or password";
		}
		
		String kreverLogin = request.getParameter("trengerLogin");
		if(kreverLogin != null) {
			//Hvis ble redirected tilbake på grunn av session timeout
			beOmPassord = "You need to be logged in to access this resource";
		}
		
		return beOmPassord;
	}
/**
 * 
 * 
 * @param request fra servlet
 * @param deltaker som skal sjekkes om er logget inn
 * @return bolsk verdi om den er logget inn
 */
	public static boolean loginOk(HttpServletRequest request, User user) {
		if(user == null) {
			return false;
		}
		
		
		//Funnet en eksisterende bruker => sjekk passord
		String gittPassord = request.getParameter("password");
		if(gittPassord == null) {
			return false;
		}
		
		return PassordUtil.sjekkPassord(gittPassord, user.getHashetPassord());
		
	}
	/**
	 * Sjekker om brukeren er logget inn
	 * 
	 * @param request fra servlet
	 * @return sjekker om bruker er logget inn
	 */
	public static boolean brukerErInnlogget(HttpServletRequest request) {
		
		HttpSession sesjon = request.getSession(false);
		
		return !(sesjon == null || sesjon.getAttribute("Username") == null);
		
	}
	/**
	 * Metode som logger bruker inn. 
	 * 
	 * @param request fra servlet
	 * @param deltaker som skal logges inn
	 * @param timeout for sesjon invalidation
	 * @return
	 */
	public static boolean loggInn(HttpServletRequest request , int timeout, UsersEAO userEAO){
		String username = request.getParameter("Username");
		User user = userEAO.findUser(username);
		
		if(!LoginUtils.loginOk(request, user)) {
			return false;
		} else {
			//Forsøk å hente session - hvis den ikke finnes, ikke opprett ny
			sessionStart(request, user, timeout);
			
			return true;
		}
	}

	/**
	 * Metode for � starte en sesjon med deltaker
	 * 
	 * @param request fra servlet
	 * @param deltaker som skal logges inn
	 * @param timeout for invalidation av sesjon
	 */
	public static void sessionStart(HttpServletRequest request, User user, int timeout) {
		HttpSession sesjon = request.getSession(false);
		if(sesjon != null) {
			//hvis session finnes, invalider session
			sesjon.invalidate();
		}
		
		//Opprett ny session
		sesjon = request.getSession(true);
		//"logg ut" etter antall sekunder gitt i web.xml
		sesjon.setMaxInactiveInterval(timeout);
		//Send videre mobilnummer
		sesjon.setAttribute("Username", user.getUsername());
	}
}
