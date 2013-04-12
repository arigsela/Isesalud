/**
 * 
 */
package com.isesalud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.isesalud.support.components.BaseModel;

/**
 * @author Ing. Ari Gerardo Sela M.
 *
 */

@Entity
@Table(name="Entidad")


public class Entidad extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4660601128184617946L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id", nullable=false,unique=true)
	private Long id;
	
	@Column(name="name", nullable=false, length = 100)
	@NotNull
	@Length(max=100)
	private String name;
	
	@Column(name="description", nullable = true, length=300)
	@Length(max=300)
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="entidad")
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	
	
	public Entidad() {
		this.id = new Long(0L);
	}
	
	public Entidad(String name) {
		this.id = new Long(0L);
		this.name = name;
	}
	
	public Entidad(String name, String description) {
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

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
