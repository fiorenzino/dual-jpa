package it.coopservice.test.repository;

import it.coopservice.test.model.UserB;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class SessionB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "PuB")
	protected EntityManager em;

	public Long persist(UserB userB) {
		try {
			em.persist(userB);
			return userB.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
