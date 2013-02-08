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
@Table(name="cancerOtrasPartes")

public class cancerOtrasPartes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7685088043306810304L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id", nullable=false, unique=true)
	private Long id;
	
	@Column(name="parteCuerpo", nullable = false, length = 100)
	@NotNull
	@Length(max=100)
	private String parteCuerpo;
	
}
