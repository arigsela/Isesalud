/**
 * 
 */
package com.isesalud.controller.query;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.isesalud.ejb.query.PersonalEjb;
import com.isesalud.model.Personal;

/**
 * @author ari
 *
 */

@Named
@ViewScoped

public class PersonalQuery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5912437410895342130L;
	@EJB
	
	private PersonalEjb ejb;
	private List<Personal> model;
	
	public List<Personal> getModel() {
		return model;
	}
	public void setModel(List<Personal> model) {
		this.model = model;
	}
	@PostConstruct
	public void init(){
		model = ejb.getAll();
	}
	
}
