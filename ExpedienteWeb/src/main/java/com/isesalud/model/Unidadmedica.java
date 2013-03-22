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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Unidadmedica")
public class Unidadmedica extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3918124057786185714L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	
	@Column(name="name", nullable = false, length = 100)
	@Length(max = 100)
	@NotNull
	private String name;
	
	@Column(name="description", nullable = true, length = 100)
	@Length(max = 100)
	private String description;
	
	@Column(name="code", nullable = false)
	private Integer code;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="unidadmedica")
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="municipio", nullable=false)
	private Municipio municipio;
	
	public Unidadmedica() {
		this.id = new Long(0L);
	}
	
	public Unidadmedica(String name, String description, Integer code,
		List<Paciente> pacientes) {
		this.id = new Long(0L);
		this.name = name;
		this.description = description;
		this.code = code;
		this.pacientes = pacientes;
	}

	public Integer getcode() {
		return code;
	}
	
	public void setcode(Integer code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
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

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
}
