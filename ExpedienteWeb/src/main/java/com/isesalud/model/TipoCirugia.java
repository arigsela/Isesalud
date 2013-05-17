package com.isesalud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.isesalud.support.components.BaseModel;

@Entity
@Table(name="TipoCirugia")
public class TipoCirugia extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 521898936217544533L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="id", nullable=false,unique=true)
	private Long id;
	
	@NotNull
	@Column(name="name", nullable=false)
	private String Name;
	
	@Column(name="description")
	private String Description;
	
	public TipoCirugia()
	{
		this.id = new Long(0L);
	}
	
	public TipoCirugia(String name, String description)
	{
		this.id = new Long(0L);
		this.Name = name;
		this.Description = description;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}

}
