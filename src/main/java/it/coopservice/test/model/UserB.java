package it.coopservice.test.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * @author fiorenzo pizza fiorenzino@gmail.com
 * 
 */
@Entity
public class UserB implements Serializable {

	private static final long serialVersionUID = -4148925628260591151L;
	private Long id;
	private String name;

	public UserB() {
		// TODO Auto-generated constructor stub
	}

	public UserB(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
