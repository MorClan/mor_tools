package net.morclan.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.morclan.enteties.Death;

@Stateless
public class DeathsEAO {
	@PersistenceContext(name="deathsPU")
	private EntityManager em;
	
	public void add(Death death) {
		em.persist(death);
	}
	public List<Death> getAll() {
		return (List<Death>) em.createQuery("SELECT d FROM Death d",Death.class).getResultList();
	}
}
