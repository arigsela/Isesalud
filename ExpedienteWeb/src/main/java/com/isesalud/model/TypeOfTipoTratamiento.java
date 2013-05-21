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
@Table(name = "typeoftipotratamiento")
public class TypeOfTipoTratamiento extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5844390438163320335L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@NotNull
	@Column(name = "name", nullable = false, length = 300)
	private String name;

	@Column(name = "description", nullable = true, length = 300)
	private String description;

	public TypeOfTipoTratamiento() {
		this.id = new Long(0L);

	}

	public TypeOfTipoTratamiento(String name) {
		this.id = new Long(0L);
		this.name = name;
	}

	public TypeOfTipoTratamiento(String name, String description) {
		this.id = new Long(0L);
		this.name = name;
		this.description = description;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
