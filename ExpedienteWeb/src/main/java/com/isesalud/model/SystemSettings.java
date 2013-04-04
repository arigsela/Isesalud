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
 * @author ari
 *
 */

@Entity
@Table(name="systemsettings")
public class SystemSettings extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8013853541683256405L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name="id", nullable=false, unique=true)
	private Long id;
	
	
	@Column(name="messagesenabled", nullable=false)
	@NotNull
	private Boolean messagesenabled;

	public SystemSettings() {
		this.id = new Long(0L);
	}
	
	public SystemSettings(Boolean messagesenabled) {
		this.id = new Long(0L);
		this.messagesenabled = messagesenabled;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;	
	}
	
	public Boolean getMessagesenabled() {
		return messagesenabled;
	}
	
	public void setMessagesenabled(Boolean messagesenabled) {
		this.messagesenabled = messagesenabled;
	}
}
