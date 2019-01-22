package net.morclan.enteties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="kdratio",name="users")
public class User {
	
	@Id
	private String username;
	
	private String hashetPassord;
	
	public User(String username, String hashetPassord) {
		this.username=username;
		this.hashetPassord=hashetPassord;
	}
	
	public User() {
		this.username="";
		this.hashetPassord="";
	}
	
	
	public String getUsername() {
		return username;
	}

	public String getHashetPassord() {
		return hashetPassord;
	}	
}
