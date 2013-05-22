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
@Table(name="TNMOnco")
public class TNMOnco extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3925735977747625285L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false, unique = true)
	private Long id;

	@Column(name="t")
	private Integer t;
	
	@Column(name="n")
	private Integer n;
	
	@Column(name="m")
	private Integer m;
	
	@Column(name="e", length=10)
	private String e;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="seguimientoOnco")
	private SeguimientoOnco seguimientoonco;
	
	public TNMOnco()
	{
		this.id = new Long(0L);
	}

	public TNMOnco(Integer t, Integer n, Integer m, String e,
			SeguimientoOnco seguimientoonco) {
		this.id = new Long(0L);
		this.t = t;
		this.n = n;
		this.m = m;
		this.e = e;
		this.seguimientoonco = seguimientoonco;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getE() {
		return e;
	}
	
	public void setE(String e) {
		this.e = e;
	}
	
	public Integer getN() {
		return n;
	}
	
	public void setN(Integer n) {
		this.n = n;
	}
	
	public Integer getM() {
		return m;
	}
	
	public void setM(Integer m) {
		this.m = m;
	}
	
	public SeguimientoOnco getSeguimientoonco() {
		return seguimientoonco;
	}
	
	public void setSeguimientoonco(SeguimientoOnco seguimientoonco) {
		this.seguimientoonco = seguimientoonco;
	}
	
	public Integer getT() {
		return t;
	}
	
	public void setT(Integer t) {
		this.t = t;
	}
	
}
