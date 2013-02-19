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
 * @author Ing. Ari G. Sela M.
 *
 */

@Entity
@Table(name="previaEnfermedad")


public class PreviaEnfermedad extends  BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2276950347639117920L;
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="illness", nullable = false)
	@NotNull
	private String illness;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="paciente", nullable = false)
	private Paciente paciente;
	
	public PreviaEnfermedad() {
		this.id = new Long(0L);
	}
	public PreviaEnfermedad(String Illness) {
		this.id = new Long(0L);
		this.illness = Illness;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}

