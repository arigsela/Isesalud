/**
 * 
 */
package com.isesalud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
/**
 * @author Ing. Ari Gerardo Sela M.
 *
 */
@Entity
@Table(name = "personal")
public class Personal extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4302068972623782136L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id", nullable = false, unique = true )
	private Long id;
	
	@Column(name="lastname" , nullable = false, length = 100)
	@Length(max = 100)
	@NotNull
	private String lastname;
	
	@Column(name="maternallastname", nullable = true, length = 100)
	@Length(max = 100)
	private String maternallastname;
	
	@Column(name="name", nullable = false, length = 100)
	@Length(max = 100)
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="puesto", nullable=false)
	private Puesto puesto;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="personal")
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMaternallastname() {
		return maternallastname;
	}
	public void setMaternallastname(String maternallastname) {
		this.maternallastname = maternallastname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Puesto getPuesto() {
		return puesto;
	}
	
	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	
}
