/**
 * 
 */
package com.isesalud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.isesalud.support.components.BaseModel;

/**
 * @author ari
 *
 */
@Entity
@Table(name="tipoestudiocita")
public class TipoEstudioCita extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3888649985277635855L;
	private Tipocita tipocita;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@NotNull
	@Column(name="descripcion",unique=false,nullable=false)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoCita", nullable = false)
	public Tipocita getTipocita() {
		return this.tipocita;
	}

	public TipoEstudioCita() {
		this.id = new Long(0L);
	}

	public TipoEstudioCita(Tipocita tipocita) {
		this.tipocita = tipocita;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
