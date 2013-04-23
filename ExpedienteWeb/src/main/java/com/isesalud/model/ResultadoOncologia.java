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
@Table(name="resultadoOncologia")
public class ResultadoOncologia extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2298841106805213785L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "dateSampleTaken")
	private Date dateSampleTaken;
	
	@Column(name = "AntHeredoFam", nullable = true)
	private String antHeredoFam;

	@Column(name = "AntPerNoPat", nullable = true)
	private String antPerNoPat;
	
	@Column(name = "AntPerPat", nullable = true)
	private String antPerPat;

	@Column(name = "PadActual", nullable = true)
	private String padActual;
	
	@Column(name = "ExpFisica", nullable = true)
	private String expFisica;
	
	@Column(name = "ImpDiag", nullable = true)
	private String impDiag;
	
	@Column(name = "PlanTratamiento", nullable = true)
	private String planTratamiento;
	
	@Column(name = "TipoTratamiento", nullable = true)
	private String tipoTratamiento;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paciente", nullable = false)
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MotivoReferencia")
	private MotivoReferencia motivoreferencia;

	
	
	public ResultadoOncologia() {
		this.id = new Long(0L);
	}

	public ResultadoOncologia(Date dateSampleTaken, String antHeredoFam,
			String antPerNoPat, String antPerPat, String padActual,
			String expFisica, String impDiag, String planTratamiento,
			String tipoTratamiento, MotivoReferencia motivoreferencia) {
		this.id = new Long(0L);
		this.dateSampleTaken = dateSampleTaken;
		this.antHeredoFam = antHeredoFam;
		this.antPerNoPat = antPerNoPat;
		this.antPerPat = antPerPat;
		this.padActual = padActual;
		this.expFisica = expFisica;
		this.impDiag = impDiag;
		this.planTratamiento = planTratamiento;
		this.tipoTratamiento = tipoTratamiento;
		this.motivoreferencia = motivoreferencia;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAntHeredoFam() {
		return antHeredoFam;
	}
	
	public void setAntHeredoFam(String antHeredoFam) {
		this.antHeredoFam = antHeredoFam;
	}
	
	public String getAntPerNoPat() {
		return antPerNoPat;
	}
	
	public void setAntPerNoPat(String antPerNoPat) {
		this.antPerNoPat = antPerNoPat;
	}
	
	public String getAntPerPat() {
		return antPerPat;
	}
	
	public void setAntPerPat(String antPerPat) {
		this.antPerPat = antPerPat;
	}
	
	public Date getDateSampleTaken() {
		return dateSampleTaken;
	}
	
	public void setDateSampleTaken(Date dateSampleTaken) {
		this.dateSampleTaken = dateSampleTaken;
	}
	
	public String getExpFisica() {
		return expFisica;
	}
	
	public void setExpFisica(String expFisica) {
		this.expFisica = expFisica;
	}
	
	public String getImpDiag() {
		return impDiag;
	}
	
	public void setImpDiag(String impDiag) {
		this.impDiag = impDiag;
	}
	
	public MotivoReferencia getMotivoreferencia() {
		return motivoreferencia;
	}
	
	public void setMotivoreferencia(MotivoReferencia motivoreferencia) {
		this.motivoreferencia = motivoreferencia;
	}
	
	public String getPadActual() {
		return padActual;
	}
	
	public void setPadActual(String padActual) {
		this.padActual = padActual;
	}
	
	public String getPlanTratamiento() {
		return planTratamiento;
	}
	
	public void setPlanTratamiento(String planTratamiento) {
		this.planTratamiento = planTratamiento;
	}
	
	public String getTipoTratamiento() {
		return tipoTratamiento;
	}
	
	public void setTipoTratamiento(String tipoTratamiento) {
		this.tipoTratamiento = tipoTratamiento;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}

