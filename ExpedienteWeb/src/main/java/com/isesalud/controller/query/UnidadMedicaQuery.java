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

import com.isesalud.ejb.query.UnidadMedicaEjb;
import com.isesalud.model.Unidadmedica;

/**
 * @author ari
 *
 */

@Named
@ViewScoped

public class UnidadMedicaQuery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 657389857857837982L;
	
	@EJB
	private UnidadMedicaEjb ejb;
	private List<Unidadmedica> model;
	
	public List<Unidadmedica> getModel() {
		return model;
	}
	public void setModel(List<Unidadmedica> model) {
		this.model = model;
	}
	@PostConstruct
	public void init(){
		model = ejb.getAllUnidadesMedicas();
	}
}
