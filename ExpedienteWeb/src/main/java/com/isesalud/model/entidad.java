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
@Table(name="Entidad")


public class entidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4660601128184617946L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@NotNull
@Column(name="id", nullable=false,unique=true)
private Long id;

@Column(name="name", nullable=false, length = 100)
@NotNull
@Length(max=100)
private String name;

@Column(name="description", nullable = true, length=300)
@Length(max=300)
private String description;

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
