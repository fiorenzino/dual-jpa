package it.coopservice.test.service.rest;

import java.io.Serializable;

import it.coopservice.test.model.UserA;
import it.coopservice.test.model.UserB;
import it.coopservice.test.repository.SessionA;
import it.coopservice.test.repository.SessionB;
import it.coopservice.test.service.ServiceAB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/test")
@Stateless
@LocalBean
public class Rest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	SessionA sessionA;
	@Inject
	SessionB sessionB;

	@Inject
	ServiceAB serviceAB;

	@GET
	@Path("/addA/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Long addA(@PathParam("name") String name) {
		UserA userA = new UserA();
		userA.setName(name);
		return sessionA.persist(userA);
	}

	@GET
	@Path("/addB/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Long addB(@PathParam("name") String name) {
		UserB userB = new UserB();
		userB.setName(name);
		return sessionB.persist(userB);
	}

	@GET
	@Path("/addAB/{nameA}/{nameB}")
	@Produces(MediaType.TEXT_PLAIN)
	public String addAB(@PathParam("nameA") String nameA,
			@PathParam("nameB") String nameB) {
		return serviceAB.createAB(nameA, nameB);
	}
}
