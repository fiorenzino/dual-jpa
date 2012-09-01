package it.coopservice.test.repository;

import java.io.Serializable;

import it.coopservice.test.model.UserA;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class SessionA implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "PuA")
	protected EntityManager em;

	public Long persist(UserA userA) {
		try {
			em.persist(userA);
			return userA.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
