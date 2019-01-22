package net.morclan.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.morclan.enteties.User;

@Stateless
public class UsersEAO {

	
	@PersistenceContext(name="usersPU")
	private EntityManager em;
	
	public User findUser(String username) {
		// TODO Auto-generated method stub
		return em.find(User.class,username);
	}
	
	public boolean userExsists(String username) {
		return (findUser(username)!=null);
	}

	public void addUser(User user) {
		System.out.println("User stuff"+user.getHashetPassord()); 
		em.persist(user);
		
	}

	

}
