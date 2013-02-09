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

import org.hibernate.validator.constraints.Length;

/**
 * @author Ing. Ari Gerardo Sela M.
 *
 */

@Entity
@Table(name="parienteCancerMama")


public class ParienteCancerMama extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5784872135266204131L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	@Column(name="relative",nullable = false, length = 100)
	@Length(max=100)
	@NotNull
	private String relative;
		
	public String getRelative() {
		return relative;
	}
	public void setRelative(String relative) {
		this.relative = relative;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ParienteCancerMama() {
		this.id = new Long(01);
 	}	
	public ParienteCancerMama(String Relative) {
		this.id = new Long(01);
		this.relative = Relative;
	}
}
