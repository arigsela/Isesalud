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
@Table(name="municipio")

public class Municipio extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7493159271361837277L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@NotNull
	@Length(max=300)
	@Column(name="name",nullable=false,length=300)
	private String name;
	
	
	@Length(max=300)
	@Column(name="description",nullable=true,length=300)
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="municipio")
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	
	public Municipio() {
		this.id = new Long(0L);
	}
	public Municipio(String name) {
		this.id = new Long(0L);
		this.name = name;
	}
	public Municipio(String name, String description) {
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
}
	
	

