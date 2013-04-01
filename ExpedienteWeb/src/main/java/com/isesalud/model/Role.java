package com.isesalud.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.isesalud.support.components.BaseModel;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@Table(name="role")
public class Role extends BaseModel {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true)
	private Long id;
	
	@Column(name="role", nullable=false, length=45)
	@NotNull
	private String role;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="roles")
	private Set<User> users = new HashSet<User>(0);
	
	
	private static final long serialVersionUID = 1L;

	public Role() {
		this.id = new Long(0L);
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users = users;
	}
   
}
