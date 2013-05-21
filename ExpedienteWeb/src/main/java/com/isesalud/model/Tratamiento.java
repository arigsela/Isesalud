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
@Table(name="tratamiento")
public class Tratamiento extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8297651842699247735L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="seguimiento")
	private SeguimientoOnco seguimiento;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tipotratamiento")
	private TipoTratamiento tipotratamiento;
	

	public Tratamiento() {
		this.id = new Long(0L);
	}

	public Tratamiento(SeguimientoOnco seguimiento,
			TipoTratamiento tipotratamiento) {
		this.id = new Long(0L);
		this.tipotratamiento = tipotratamiento;
		this.seguimiento = seguimiento;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public SeguimientoOnco getSeguimiento() {
		return seguimiento;
	}
	
	public void setSeguimiento(SeguimientoOnco seguimiento) {
		this.seguimiento = seguimiento;
	}
	
	public TipoTratamiento getTipoTratamiento() {
		return tipotratamiento;
	}
	
	public void setTipoTratamiento(
			TipoTratamiento tipotratamiento) {
		this.tipotratamiento = tipotratamiento;
	}
}
