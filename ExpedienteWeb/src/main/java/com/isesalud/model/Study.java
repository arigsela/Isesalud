/**
 * 
 */
package com.isesalud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.isesalud.support.components.BaseModel;

/**
 * @author ari
 * 
 */
@Entity
@Table(name = "study")
public class Study extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3888649985277635855L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name", unique = true, nullable = false)
	@NotNull
	private String name;

	@NotNull
	@Column(name = "notes", unique = false, nullable = false)
	private String notes;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "modality", nullable = false)
	private Modality modality;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "study")
	private List<Cita> citas = new ArrayList<Cita>();

	public Study() {
		this.id = new Long(0L);
	}

	public Study(String name, String notes) {
		this.id = new Long(0L);
		this.name = name;
		this.notes = notes;
	}

	@Override
	public Long getId() {
		return this.id;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Modality getModality() {
		return modality;
	}
	
	public void setModality(Modality modality) {
		this.modality = modality;
	}


}
