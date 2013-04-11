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
@Table(name="hallazgos")
public class Hallazgos extends BaseModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1329688385008546194L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id", nullable=false, unique=true)
	private Long id;
	
	@Column(name="name", nullable=false)
	@NotNull
	private String name;
	
	@Column(name="side",nullable=false)
	@NotNull
	private String side;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="resultadoImagen", nullable = false)
	private resultadoImagen resultadoimagen;
	
	public Hallazgos() {
		this.id = new Long(0L);
	}

	public Hallazgos(String name, String side) {
		this.id = new Long(0L);
		this.name = name;
		this.side = side;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSide() {
		return side;
	}
	
	public void setSide(String side) {
		this.side = side;
	}

	public resultadoImagen getResultadoimagen() {
		return resultadoimagen;
	}
	
	public void setResultadoimagen(resultadoImagen resultadoimagen) {
		this.resultadoimagen = resultadoimagen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((resultadoimagen == null) ? 0 : resultadoimagen.hashCode());
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hallazgos other = (Hallazgos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (resultadoimagen == null) {
			if (other.resultadoimagen != null)
				return false;
		} else if (!resultadoimagen.equals(other.resultadoimagen))
			return false;
		if (side == null) {
			if (other.side != null)
				return false;
		} else if (!side.equals(other.side))
			return false;
		return true;
	}
}
