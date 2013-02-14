
package com.isesalud.controller.query;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.isesalud.ejb.query.EntidadEjb;
import com.isesalud.model.Entidad;

/**
 * @author Ing. Ari G. Sela M.
 *
 */
@Named
@ViewScoped
public class EntidadQuery implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2759413130089706085L;
	@EJB
	private EntidadEjb ejb;
	
	private List<Entidad> model;
	
	public List<Entidad> getModel() {
		return model;
	}
	
	public void setModel(List<Entidad> model) {
		this.model = model;
	}
	
	@PostConstruct
	public void Init(){
		model = ejb.getAllEntidades();
	}

}
