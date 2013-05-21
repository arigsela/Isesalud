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
@Table(name="tipolineamedicamento")
public class TipoLineaMedicamento extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3680428637289957134L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@NotNull
	@Column(name="description", nullable=false)
	private String description;
	
	public TipoLineaMedicamento() {
		this.id = new Long(0L);
	}
	
	public TipoLineaMedicamento(String description) {
		this.id = new Long(0L);
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

}
