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
@Table(name="SeguimientoOnco")
public class SeguimientoOnco extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1952296675274530137L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;
	
	@NotNull
	@Column(name="numcita", nullable = false)
	private Integer numcita;
	
	@NotNull
	@Column(name="tipoplanmanejo", nullable = false)
	private Integer tipoplanmanejo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaingresotratamiento")
	private Date fechaingresotratamiento;
	
	@Column(name="refapoyopsicologico")
	private Boolean refapoyopsicologico;
	
	@Column(name="refrehabilitacion")
	private Boolean refrehabilitacion;
	
	@Column(name="tnmclasificado")
	private Boolean tnmclasificado;
	
	@Column(name="rfcmedicotratante", nullable = false, length = 20)
	private String rfcmedicotratante;
	
	@Column(name="observaciones", nullable = true, length = 65535)
	private String observaciones;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TipoCirugia")
	private TipoCirugia tipocirugia;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TipoEstadoActualPacienteOnco")
	private TipoEstadoActualPacienteOnco tipoestadoactualpacienteonco;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TipoTratamientoQuimio")
	private TipoTratamientoQuimio tipotratamientoquimio;
	

	
	public SeguimientoOnco()
	{
		this.id = new Long(0L);
	}
	
	public SeguimientoOnco(Integer numcita, Integer tipoplanmanejo,
			Date fechaingresotratamiento, Boolean refapoyopsicologico,
			Boolean refrehabilitacion, Boolean tnmclasificado,
			String rfcmedicotratante, String observaciones, TipoCirugia tipocirugia,
			TipoTratamientoQuimio tipotratamientoquimio, 
			TipoEstadoActualPacienteOnco tipoestadoactualpacienteonco) {
		this.id = new Long(0L);
		this.numcita = numcita;
		this.tipoplanmanejo = tipoplanmanejo;
		this.fechaingresotratamiento = fechaingresotratamiento;
		this.refapoyopsicologico = refapoyopsicologico;
		this.refrehabilitacion = refrehabilitacion;
		this.tnmclasificado = tnmclasificado;
		this.rfcmedicotratante = rfcmedicotratante;
		this.observaciones = observaciones;
		this.tipocirugia = tipocirugia;
		this.tipotratamientoquimio = tipotratamientoquimio;
		this.tipoestadoactualpacienteonco = tipoestadoactualpacienteonco;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFechaingresotratamiento() {
		return fechaingresotratamiento;
	}
	
	public void setFechaingresotratamiento(Date fechaingresotratamiento) {
		this.fechaingresotratamiento = fechaingresotratamiento;
	}
	
	public Integer getNumcita() {
		return numcita;
	}
	
	public void setNumcita(Integer numcita) {
		this.numcita = numcita;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public Boolean getRefapoyopsicologico() {
		return refapoyopsicologico;
	}
	
	public void setRefapoyopsicologico(Boolean refapoyopsicologico) {
		this.refapoyopsicologico = refapoyopsicologico;
	}
	
	public Boolean getRefrehabilitacion() {
		return refrehabilitacion;
	}
	
	public void setRefrehabilitacion(Boolean refrehabilitacion) {
		this.refrehabilitacion = refrehabilitacion;
	}
	
	public String getRfcmedicotratante() {
		return rfcmedicotratante;
	}
	
	public void setRfcmedicotratante(String rfcmedicotratante) {
		this.rfcmedicotratante = rfcmedicotratante;
	}
	
	public Integer getTipoplanmanejo() {
		return tipoplanmanejo;
	}
	
	public void setTipoplanmanejo(Integer tipoplanmanejo) {
		this.tipoplanmanejo = tipoplanmanejo;
	}
	
	public Boolean getTnmclasificado() {
		return tnmclasificado;
	}
	
	public void setTnmclasificado(Boolean tnmclasificado) {
		this.tnmclasificado = tnmclasificado;
	}
	
	public TipoCirugia getTipocirugia() {
		return tipocirugia;
	}
	
	public void setTipocirugia(TipoCirugia tipocirugia) {
		this.tipocirugia = tipocirugia;
	}
	
	public TipoTratamientoQuimio getTipotratamientoquimio() {
		return tipotratamientoquimio;
	}
	
	public void setTipotratamientoquimio(
			TipoTratamientoQuimio tipotratamientoquimio) {
		this.tipotratamientoquimio = tipotratamientoquimio;
	}
	
	public TipoEstadoActualPacienteOnco getTipoestadoactualpacienteonco() {
		return tipoestadoactualpacienteonco;
	}
	
	public void setTipoestadoactualpacienteonco(
			TipoEstadoActualPacienteOnco tipoestadoactualpacienteonco) {
		this.tipoestadoactualpacienteonco = tipoestadoactualpacienteonco;
	}
	
}
