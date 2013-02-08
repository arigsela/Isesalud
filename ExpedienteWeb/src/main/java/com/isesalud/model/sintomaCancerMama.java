/**
 * 
 */
package com.isesalud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author Ing. Ari Gerardo Sela M.
 *
 */

@Entity
@Table(name="sintomaCancerMama")

public class sintomaCancerMama implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6277767250072233650L;

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="sintomaLado",nullable=false, length=20)
	@Length(max=20)
	@NotNull
	private String sintomaLado;
	
	@Column(name="sintomaNombre",nullable=false, length=100)
	@Length(max=100)
	@NotNull
	private String sintomaNombre;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSintomaLado() {
		return sintomaLado;
	}
	public void setSintomaLado(String sintomaLado) {
		this.sintomaLado = sintomaLado;
	}
	public String getSintomaNombre() {
		return sintomaNombre;
	}
	public void setSintomaNombre(String sintomaNombre) {
		this.sintomaNombre = sintomaNombre;
	}
}
