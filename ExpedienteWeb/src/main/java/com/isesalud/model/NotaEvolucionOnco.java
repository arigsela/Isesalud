/**
 * 
 */
package com.isesalud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.isesalud.support.components.BaseModel;

/**
 * @author ari
 *
 */
@Entity
@Table(name="notaevoluciononco")
public class NotaEvolucionOnco extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -189555638543572185L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@Column(name="nota", length=65535)
	private String nota;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateCreated")
	private Date datecreated;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="historiaclinicaonco")
	private HistoriaClinicaOnco historiaclinicaonco;
	
	public NotaEvolucionOnco() {
		this.id = new Long(0L);
	}

	public NotaEvolucionOnco(String nota, Date datecreated,
			HistoriaClinicaOnco historiaclinicaonco) {
		this.id = new Long(0L);
		this.nota = nota;
		this.datecreated = datecreated;
		this.historiaclinicaonco = historiaclinicaonco;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDatecreated() {
		return datecreated;
	}
	
	public void setDatecreated(Date datecreated) {
		this.datecreated = datecreated;
	}
	
	public HistoriaClinicaOnco getHistoriaclinicaonco() {
		return historiaclinicaonco;
	}
	
	public void setHistoriaclinicaonco(HistoriaClinicaOnco historiaclinicaonco) {
		this.historiaclinicaonco = historiaclinicaonco;
	}
	
	public String getNota() {
		return nota;
	}
	
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	
	
	
	

}
