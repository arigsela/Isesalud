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

import com.isesalud.ejb.query.MunicipioEjb;
import com.isesalud.model.Municipio;

/**
 * @author Haysoos
 *
 */
@Named
@ViewScoped
public class MunicipioQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1181359214684231966L;
	
	@EJB
	private MunicipioEjb ejb;
	
	private List<Municipio> model;
	
	public List<Municipio> getModel() {
		return model;
	}
	
	public void setModel(List<Municipio> model) {
		this.model = model;
	}
	
	@PostConstruct
	public void init(){
		model = ejb.getAllMunicipios();
	}
	
}
