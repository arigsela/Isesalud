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
@Table(name="LineaMedicamento")
public class LineaMedicamento extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3208421352906047162L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TipoLineaMedicamento")
	private TipoLineaMedicamento tipolineamedicamento;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="seguimiento")
	private SeguimientoOnco seguimientoonco;
	
	public LineaMedicamento()
	{
		this.id = new Long(0L);
	}

	public LineaMedicamento(TipoLineaMedicamento tipolineamedicamento,
			SeguimientoOnco seguimientoonco) {
		this.id = new Long(0L);
		this.tipolineamedicamento = tipolineamedicamento;
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
	
	public TipoLineaMedicamento getTipoLineamedicamento() {
		return tipolineamedicamento;
	}
	
	public void setTipoLineaMedicamento(TipoLineaMedicamento tipolineamedicamento) {
		this.tipolineamedicamento = tipolineamedicamento;
	}

	
}
