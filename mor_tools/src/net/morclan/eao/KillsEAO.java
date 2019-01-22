package net.morclan.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.morclan.enteties.Kill;

@Stateless
public class KillsEAO {
	@PersistenceContext(name="killsPU")
	private EntityManager em;
	
	public void add(Kill kill) {
		em.persist(kill);
	}
	public List<Kill> getAll() {
		List<Kill>all =em.createQuery("SELECT k FROM Kill k",Kill.class).getResultList();
		return all;
	}
		
	
}
