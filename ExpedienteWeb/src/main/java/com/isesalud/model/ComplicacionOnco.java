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
@Table(name="complicaciononco")
public class ComplicacionOnco extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1287923180919415480L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TipoComplicacion")
	private TipoComplicacion tipocomplicacion;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="seguimientoonco")
	private SeguimientoOnco seguimientoonco;
	
	public ComplicacionOnco() {
		this.id = new Long(0L);
	}

	public ComplicacionOnco(//TipoComplicacion tipocomplicacion,
			SeguimientoOnco seguimientoonco) {
		this.id = new Long(0L);
		//this.tipocomplicacion = tipocomplicacion;
		this.seguimientoonco = seguimientoonco;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public SeguimientoOnco getSeguimientoonco() {
		return seguimientoonco;
	}
	
	public void setSeguimientoonco(SeguimientoOnco seguimientoonco) {
		this.seguimientoonco = seguimientoonco;
	}
	
/*	public TipoComplicacion getTipocomplicacion() {
		return tipocomplicacion;
	}
	
	public void setTipocomplicacion(TipoComplicacion tipocomplicacion) {
		this.tipocomplicacion = tipocomplicacion;
	}*/

}
