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
@Table(name = "Unidadmedica")
public class Unidadmedica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3918124057786185714L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	
	@Column(name="name", nullable = false, length = 100)
	@Length(max = 100)
	@NotNull
	private String name;
	
	@Column(name="description", nullable = true, length = 100)
	@Length(max = 100)
	private String description;
	
	@Column(name="code", nullable = false)
	private Integer code;
		
	public Integer getcode() {
		return code;
	}
	
	public void setcode(Integer code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
}
