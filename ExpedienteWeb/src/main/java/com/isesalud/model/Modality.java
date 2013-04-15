/**
 * 
 */
package com.isesalud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.isesalud.support.components.BaseModel;

/**
 * @author ari
 *
 */
@Entity
@Table(name="modality")
public class Modality extends BaseModel {

/**
	 * 
	 */
	private static final long serialVersionUID = 325314695661329313L;

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

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "department", nullable = false)
private Department department;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "modality")
private List<Study> studies = new ArrayList<Study>(0);

public Modality() {
	this.id = new Long(0L);
}

public Modality(String name) {
	this.id = new Long(0L);
	this.name = name;
}

public Modality(String name, String description) {
	this.id = new Long(0L);
	this.name = name;
	this.description = description;
}

public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}

@Override
public Long getId() {
	return id;
}

@Override
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

public List<Study> getStudies() {
	return studies;
}

public void setStudies(List<Study> studies) {
	this.studies = studies;
}

}

