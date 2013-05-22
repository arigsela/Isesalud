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
@Table(name="tipoestadoactualpacienteonco")
public class TipoEstadoActualPacienteOnco extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6109890858043622162L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id", nullable=false,unique=true)
	private Long id;
	
	@Column(name="description")
	private String description;
	
	public TipoEstadoActualPacienteOnco() 
	{
		this.id = new Long(0L);
	}
	
	public TipoEstadoActualPacienteOnco(String description)
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
