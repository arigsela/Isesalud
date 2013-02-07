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
 * @author Jesus Espinoza Hernandez
 *
 */
@Entity
@Table(name = "puesto")
public class Puesto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7701888460658964373L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name = "id", nullable=false, unique=true)
	private Long id;
	
	@Column(name="name", nullable = false, length = 100)
	@Length(max = 100)
	@NotNull
	private String name;
	
	@Column(name="description", nullable = true)
	private String description;
	
	public Puesto(){
		this.id = new Long(0l);
	}
	
	public Puesto(String name){
		this.id = new Long(0l);
		this.name = name;
	}
	
	public Puesto(String name, String description){
		this.id = new Long(0l);
		this.name = name;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
