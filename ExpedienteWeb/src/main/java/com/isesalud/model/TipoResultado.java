/**
 * 
 */
package com.isesalud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.isesalud.support.components.BaseModel;

/**
 * @author Ing. Ari G. Sela M.
 *
 */
@Entity
@Table(name="tipoResultado")
public class TipoResultado extends BaseModel{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 2061224615423624434L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@NotNull
@Column(name = "id", nullable = false, unique = true)
private Long id;

@Column(name="name",nullable=false,length=300)
private String name;

@Column(name="description",nullable=true,length=300)
private String description;

public TipoResultado() {
	this.id = new Long(0L);
}

public TipoResultado(String name) {
	this.id = new Long(0L);
	this.name = name;
}

public TipoResultado(String name, String description) {
	this.id = new Long(0L);
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
