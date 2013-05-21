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
@Table(name="medicamentoprescrito")
public class MedicamentoPrescrito extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6903116265878946449L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="seguimientoOnco")
	private SeguimientoOnco seguimientoonco;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tipomedicamento")
	private TipoMedicamento tipomedicamento;
	
	public MedicamentoPrescrito()
	{
		this.id = new Long(0L);
	}
	
	public MedicamentoPrescrito(SeguimientoOnco seguimientoonco, TipoMedicamento tipomedicamento)
	{
		this.id = new Long(0L);
		this.seguimientoonco = seguimientoonco;
		this.tipomedicamento = tipomedicamento;
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
	
	public TipoMedicamento getTipomedicamento() {
		return tipomedicamento;
	}
	
	public void setTipomedicamento(TipoMedicamento tipomedicamento) {
		this.tipomedicamento = tipomedicamento;
	}
}
