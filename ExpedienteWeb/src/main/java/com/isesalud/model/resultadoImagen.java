/**
 * 
 */
package com.isesalud.model;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.isesalud.support.components.BaseModel;

/**
 * @author Ing. Ari G. Sela M.
 *
 */
@Entity
@Table(name="resultadoImagen")
public class resultadoImagen extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4274584460587378386L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false,unique=true)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateInterpreted",nullable = false)
	@NotNull
	private Date dateinterpreted;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateNotified",nullable = true)
	private Date dateNotified;
	
	@Temporal(TemporalType.DATE)
	@Column(name="daterealized",nullable = false)
	@NotNull
	private Date daterealized;
	
	@Column(name="signs", nullable=true)
	private String signs;
	
	@Column(name="adequate",nullable = false)
	@NotNull
	private Boolean adequate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="paciente", nullable = false)
	private Paciente paciente;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TipoEstudioCita", nullable = false)
	private TipoEstudioCita tipoestudiocita;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="personal", nullable = false)
	private Personal personal;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="gabinete", nullable = false)
	private Gabinete gabinete;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TipoResultado", nullable = false)
	private TipoResultado tiporesultado;
	
	@ManyToOne(fetch=FetchType.EAGER)

	@JoinColumn(name="MotivoInadecuada")
	private MotivoInadecuada motivoinadecuada;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="resultadoimagen")
	private List<Hallazgos> hallazgos = new ArrayList<Hallazgos>();
	
	public resultadoImagen() {
		this.id = new Long(0L);
	}

	public resultadoImagen(Date dateinterpreted, Date dateNotified,
			Date daterealized, String signs, Boolean adequate,
			Paciente paciente, TipoEstudioCita tipoestudiocita,
			Personal personal, Gabinete gabinete, TipoResultado tiporesultado,
			MotivoInadecuada motivoinadecuada, List<Hallazgos> hallazgos) {
		this.id = new Long(0L);
		this.dateinterpreted = dateinterpreted;
		this.dateNotified = dateNotified;
		this.daterealized = daterealized;
		this.signs = signs;
		this.adequate = adequate;
		this.paciente = paciente;
		this.tipoestudiocita = tipoestudiocita;
		this.personal = personal;
		this.gabinete = gabinete;
		this.tiporesultado = tiporesultado;
		this.motivoinadecuada = motivoinadecuada;
		this.hallazgos = hallazgos;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getAdequate() {
		return adequate;
	}
	
	public void setAdequate(Boolean adequate) {
		this.adequate = adequate;
	}
	
	public Date getDateinterpreted() {
		return dateinterpreted;
	}
	
	public void setDateinterpreted(Date dateinterpreted) {
		this.dateinterpreted = dateinterpreted;
	}
	
	public Date getDateNotified() {
		return dateNotified;
	}
	
	public void setDateNotified(Date dateNotified) {
		this.dateNotified = dateNotified;
	}
	
	public Date getDaterealized() {
		return daterealized;
	}
	
	public void setDaterealized(Date daterealized) {
		this.daterealized = daterealized;
	}
	
	public Gabinete getGabinete() {
		return gabinete;
	}
	
	public void setGabinete(Gabinete gabinete) {
		this.gabinete = gabinete;
	}
	
	public List<Hallazgos> getHallazgos() {
		return hallazgos;
	}
	
	public void setHallazgos(List<Hallazgos> hallazgos) {
		this.hallazgos = hallazgos;
	}
	
	public MotivoInadecuada getMotivoinadecuada() {
		return motivoinadecuada;
	}
	
	public void setMotivoinadecuada(MotivoInadecuada motivoinadecuada) {
		this.motivoinadecuada = motivoinadecuada;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Personal getPersonal() {
		return personal;
	}
	
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	
	public String getSigns() {
		return signs;
	}
	
	public void setSigns(String signs) {
		this.signs = signs;
	}
	
	public TipoEstudioCita getTipoestudiocita() {
		return tipoestudiocita;
	}
	
	public void setTipoestudiocita(TipoEstudioCita tipoestudiocita) {
		this.tipoestudiocita = tipoestudiocita;
	}
	
	public TipoResultado getTiporesultado() {
		return tiporesultado;
	}
	
	public void setTiporesultado(TipoResultado tiporesultado) {
		this.tiporesultado = tiporesultado;
	}

}
