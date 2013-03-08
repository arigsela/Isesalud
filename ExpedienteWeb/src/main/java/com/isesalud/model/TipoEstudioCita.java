/**
 * 
 */
package com.isesalud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="name", unique=true, nullable=false)
	@NotNull
	private String name;
	
	@NotNull
	@Column(name="notes",unique=false,nullable=false)
	private String notes;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tipocita", nullable = false)
	private Tipocita tipocita;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoestudiocita")
	private List<Cita> citas = new ArrayList<Cita>();
	
	public TipoEstudioCita() {
		this.id = new Long(0L);
	}

	public TipoEstudioCita(String name, String notes) {
		this.id = new Long(0L);
		this.name = name;
		this.notes = notes;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public List<Cita> getCitas() {
		return citas;
	}
	
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	
	public Tipocita getTipocita() {
		return this.tipocita;
	}

	public void setTipocita(Tipocita tipocita) {
		this.tipocita = tipocita;
	}
	
}
