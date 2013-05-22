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
@Table(name="tipotratamientoquimio")
public class TipoTratamientoQuimio extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9130526301363044358L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id", nullable=false,unique=true)
	private Long id;
	
	@Column(name="description", nullable= false)
	private String description;

	public TipoTratamientoQuimio() {
		this.id = new Long(0L);
	}
	
	public TipoTratamientoQuimio(String description)
	{
		this.id = new Long(0L);
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getdescription() {
		return description;
	}
	
	public void setdescription(String description) {
		this.description = description;
	}
}
