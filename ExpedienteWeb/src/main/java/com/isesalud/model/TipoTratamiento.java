/**
 * 
 */
package com.isesalud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.isesalud.support.components.BaseModel;

/**
 * @author ari
 *
 */
@Entity
@Table(name="TipoTratamiento")
public class TipoTratamiento extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8297651842699247735L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@NotNull
	@Column(name="name", nullable = false)
	private String Name;
	
	@Column(name="description")
	private String Description;

	public TipoTratamiento() {
		this.id = new Long(0L);
	}

	public TipoTratamiento(String name, String description) {
		this.id = new Long(0L);
		Name = name;
		Description = description;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	
	
	
	
}
