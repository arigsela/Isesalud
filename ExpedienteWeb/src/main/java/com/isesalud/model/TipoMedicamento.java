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
@Table(name="tipomedicamento")
public class TipoMedicamento extends BaseModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6542185426819913048L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="description", nullable = false, length = 300)
	private String description;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tipolineamedicamento")
	private TipoLineaMedicamento tipolineamedicamento;
	
	public TipoMedicamento()
	{
		this.id = new Long(0L);
	}
	
	public TipoMedicamento(String description, TipoLineaMedicamento tipolineamedicamento)
	{
		this.id = new Long(0L);
		this.description = description;
		this.tipolineamedicamento = tipolineamedicamento;
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
	
	public TipoLineaMedicamento getTipolineamedicamento() {
		return tipolineamedicamento;
	}
	
	public void setTipolineamedicamento(
			TipoLineaMedicamento tipolineamedicamento) {
		this.tipolineamedicamento = tipolineamedicamento;
	}
}
