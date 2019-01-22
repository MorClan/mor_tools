package net.morclan.beans;


import javax.servlet.http.HttpServletRequest;


import net.morclan.eao.UsersEAO;
import net.morclan.enteties.User;
import net.morclan.utils.InputValidator;
import net.morclan.utils.PassordUtil;


public class Skjema {
	
	private String username;
	private String usernameFeilmelding;	
	private String password;
	private String passwordFeilmelding;
	private String passwordRepetert;
	private String passwordRepetertFeilmelding;
	
	private UsersEAO userEAO;
	
	
	
	

	public Skjema(HttpServletRequest request, UsersEAO userEAO) {
		this.username=request.getParameter("Username");
		this.password = request.getParameter("password");
		this.passwordRepetert = request.getParameter("passwordRepetert");
		this.userEAO = userEAO;
		
	}
	
	public boolean isAltGyldig() {
		
		return isFornavnGyldig() && isIkkeTidligereRegistrert() && isPassordGyldig() && isPassordLike();
	}
	
	private boolean isIkkeTidligereRegistrert() {
		return !userEAO.userExsists(username);
	}

	public boolean isFornavnGyldig() {
		return InputValidator.isFornavnGyldig(username);
		
	}
	
	private boolean isPassordGyldig() {
		return InputValidator.isPassordGyldig(password) ;
	}
	
	private boolean isPassordLike() {
		if(password == null || passwordRepetert == null) {
			return false;
		}
		return password.equals(passwordRepetert);
	}

	public void setupFeilMeldinger() {
		if(!isFornavnGyldig()) {
			username = "";
			usernameFeilmelding = "Invalid Username";
		}
		if(!isPassordGyldig()) {
			passwordFeilmelding = "Invalid Password";
		}
		if(!isPassordLike()) {
			passwordRepetertFeilmelding = "Passwords have to match";
		}
	}


	public User createUser() {
		User ny = new User(username, PassordUtil.krypterPassord(password));
		return ny;
	}

	public void setupFeilMeldinger(String string) {
		setupFeilMeldinger();
		usernameFeilmelding = "Bruker finnes allerede";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernameFeilmelding() {
		return usernameFeilmelding;
	}

	public void setUsernameFeilmelding(String usernameFeilmelding) {
		this.usernameFeilmelding = usernameFeilmelding;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordFeilmelding() {
		return passwordFeilmelding;
	}

	public void setPasswordFeilmelding(String passwordFeilmelding) {
		this.passwordFeilmelding = passwordFeilmelding;
	}

	public String getPasswordRepetert() {
		return passwordRepetert;
	}

	public void setPasswordRepetert(String passwordRepetert) {
		this.passwordRepetert = passwordRepetert;
	}

	public String getPasswordRepetertFeilmelding() {
		return passwordRepetertFeilmelding;
	}

	public void setPasswordRepetertFeilmelding(String passwordRepetertFeilmelding) {
		this.passwordRepetertFeilmelding = passwordRepetertFeilmelding;
	}

}
