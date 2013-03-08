
/**
 * 
 */
package com.isesalud.model;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.isesalud.support.components.BaseModel;

/**
 * @author Ing. Ari Gerardo Sela M.
 *
 */

@Entity
@Table(name="paciente")

public class Paciente extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2325369627028054544L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable = false,unique=true)
	private Long id;
	
	@Column(name="lastName", nullable = false, length = 100)
	@Length(max=100)
	@NotNull
	private String lastName;
	
	@Column(name="maternalLastName", nullable = true, length = 100)
	@Length(max=100)
	private String maternalLastName;
	
	@Column(name="name",nullable = false, length = 100)
	@NotNull
	@Length(max=100)
	private String name;
	
	
	@Column(name="dateOfBirth", nullable = false)
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateofBirth;
	
	@Column(name="phoneNumber", nullable = true, length = 20)
	@Length(max=20)
	private String phoneNumber;
	
	@Column(name="email", nullable = true, length = 300)
	@Length(max=300)
	@Email
	private String email;
	
	@Column(name="address", nullable = true, length = 300)
	@Length(max=300)
	private String address;
	
	@Column(name="sex", nullable = false)
	@NotNull
	private char sex;
	
	@Column(name="seguroPopular", nullable = true)
	private String seguroPopular;
	
	@Column(name="dateCreated", nullable=false)
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateCreated;
	
	@Column(name="timeCreated",nullable = false)
	@NotNull
	@Temporal(TemporalType.TIME)
	private Date timeCreated;
	
	@Column(name="ageMenstruation", nullable = false)
	@NotNull
	private Integer ageMenstruation;
	
	@Column(name="ageFirstChild", nullable = false)
	@NotNull
	private Integer ageFirstChild;
	
	@Column(name="BreastFeedChild", nullable = false)
	@NotNull
	private Boolean BreastFeedChild;
	
	@Column (name="yearsSinceSurgery", nullable = false)
	@NotNull
	private Integer yearsSinceSurgery;
	
	@Column (name = "ageMenopause",nullable = false)
	@NotNull
	private Integer ageMenopause;
	
	@Column (name = "ageMenopauseHormones", nullable = false)
	@NotNull
	private Integer ageMenopauseHormones;
	
	@Column(name = "DateLastMG", nullable = false)
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateLastMG;
	
	@Column (name = "observations", nullable = true, length = 300)
	@Length(max = 300)
	private String observations;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="municipio",nullable=false)
	private Municipio municipio;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="entidad", nullable = false)
	private Entidad entidad;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="unidadmedica", nullable = false)
	private Unidadmedica unidadmedica;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private List<ParienteCancerMama> parientescancermama = new ArrayList<ParienteCancerMama>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private List<CancerOtrasPartes> canceresOtraPartes = new ArrayList<CancerOtrasPartes>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private List<PreviaEnfermedad> previasenfermedades = new ArrayList<PreviaEnfermedad>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private List<SintomaCancerMama> SintomasCancerMama = new ArrayList<SintomaCancerMama>();
	 
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy="paciente")
	private List<Cita> citas = new ArrayList<Cita>();
	
	public Paciente() {
		this.id = new Long(0L);
	}
	
	public Paciente(String lastName, String maternalLastName, String name,
			Date dateofBirth, String phoneNumber,String email, String address, char sex,
			Personal personal, Municipio municipio, Entidad entidad,
			Unidadmedica unidadmedica) {
		this.id = new Long(0L);
		this.lastName = lastName;
		this.maternalLastName = maternalLastName;
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.sex = sex;
		this.municipio = municipio;
		this.entidad = entidad;
		this.unidadmedica = unidadmedica;
		this.email = email;
	}
	
	public List<Cita> getCitas() {
		return citas;
	}
	
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	
	public List<SintomaCancerMama> getSintomasCancerMama() {
		return SintomasCancerMama;
	}
	public void setSintomasCancerMama(List<SintomaCancerMama> sintomasCancerMama) {
		SintomasCancerMama = sintomasCancerMama;
	}
	
	public List<CancerOtrasPartes> getCanceresOtraPartes() {
		return canceresOtraPartes;
	}
	
	public void setCanceresOtraPartes(List<CancerOtrasPartes> canceresOtraPartes) {
		this.canceresOtraPartes = canceresOtraPartes;
	}
	
	public List<PreviaEnfermedad> getPreviasenfermedades() {
		return previasenfermedades;
	}
	
	public void setPreviasenfermedades(List<PreviaEnfermedad> previasenfermedades) {
		this.previasenfermedades = previasenfermedades;
	}
	
	public Entidad getEntidad() {
		return entidad;
	}
	
	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}
	
	public Unidadmedica getUnidadmedica() {
		return unidadmedica;
	}
	 
	public void setUnidadmedica(Unidadmedica unidadmedica) {
		this.unidadmedica = unidadmedica;
	}
	
	public Municipio getMunicipio() {
		return municipio;
	}
	
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	public List<ParienteCancerMama> getParientescancermama() {
		return parientescancermama;
	}
	public void setParientescancermama(List<ParienteCancerMama> parientescancermama) {
		this.parientescancermama = parientescancermama;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAgeFirstChild() {
		return ageFirstChild;
	}
	
	public void setAgeFirstChild(Integer ageFirstChild) {
		this.ageFirstChild = ageFirstChild;
	}
	public Integer getAgeMenopause() {
		return ageMenopause;
	}
	public void setAgeMenopause(Integer ageMenopause) {
		this.ageMenopause = ageMenopause;
	}
	public Integer getAgeMenopauseHormones() {
		return ageMenopauseHormones;
	}
	public void setAgeMenopauseHormones(Integer ageMenopauseHormones) {
		this.ageMenopauseHormones = ageMenopauseHormones;
	}
	public Integer getAgeMenstruation() {
		return ageMenstruation;
	}
	public void setAgeMenstruation(Integer ageMenstruation) {
		this.ageMenstruation = ageMenstruation;
	}
	public Boolean getBreastFeedChild() {
		return BreastFeedChild;
	}
	public void setBreastFeedChild(Boolean breastFeedChild) {
		BreastFeedChild = breastFeedChild;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateLastMG() {
		return dateLastMG;
	}
	public void setDateLastMG(Date dateLastMG) {
		this.dateLastMG = dateLastMG;
	}
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMaternalLastName() {
		return maternalLastName;
	}
	public void setMaternalLastName(String maternalLastName) {
		this.maternalLastName = maternalLastName;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSeguroPopular() {
		return seguroPopular;
	}
	public void setSeguroPopular(String seguroPopular) {
		this.seguroPopular = seguroPopular;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Date getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}
	public Integer getYearsSinceSurgery() {
		return yearsSinceSurgery;
	}
	public void setYearsSinceSurgery(Integer yearsSinceSurgery) {
		this.yearsSinceSurgery = yearsSinceSurgery;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public void initLazyElements() {
		Hibernate.initialize(SintomasCancerMama);
		Hibernate.initialize(parientescancermama);
		Hibernate.initialize(previasenfermedades);
		Hibernate.initialize(canceresOtraPartes);
	}
}



