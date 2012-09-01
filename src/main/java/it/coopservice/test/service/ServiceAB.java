package it.coopservice.test.service;

import it.coopservice.test.model.UserA;
import it.coopservice.test.model.UserB;
import it.coopservice.test.repository.SessionA;
import it.coopservice.test.repository.SessionB;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 * 
 * @author fiorenzo pizza fiorenzino@gmail.com
 * 
 */
@Stateless
@LocalBean
public class ServiceAB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	SessionA sessionA;

	@Inject
	SessionB sessionB;

	public String createAB(String nameA, String nameB) {
		UserA userA = new UserA(nameA);
		Long idA = sessionA.persist(userA);
		UserB userB = new UserB(nameB);
		Long idB = sessionB.persist(userB);
		return "a:" + idA + " - b:" + idB;
	}
}
