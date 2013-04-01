package com.isesalud.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.isesalud.support.components.BaseModel;

/**
 * Entity implementation class for Entity: Users
 *
 */
@Entity
@Table(name = "user")
public class User extends BaseModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="username", unique=true, nullable=false, length=45)
	@NotNull
	private String username;
	
	@Column(name="password", nullable=false, length=45)
	@NotNull
	private String password;
	
	@Column(name="name", nullable=false, length=45)
	@NotNull
	private String name;
	
	@Column(name="fName", nullable=false, length=45)
	@NotNull
	private String fName;
	
	@Column(name="mName", length=45)
	private String mName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_has_role", joinColumns = { @JoinColumn(name = "User_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Role_id", nullable = false, updatable = false) })
	private Set<Role> roles = new HashSet<Role>(0);
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="municipio", nullable=false)
	private Municipio municipio;
	
	private static final long serialVersionUID = 1L;

	public User() {
		this.id = new Long(0L);
	}   

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getmName() {
		return mName;
	}
	
	public void setmName(String mName) {
		this.mName = mName;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
   
}
