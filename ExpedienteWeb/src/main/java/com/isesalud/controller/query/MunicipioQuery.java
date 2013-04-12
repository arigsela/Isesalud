/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.isesalud.ejb.query.MunicipioEjb;
import com.isesalud.model.Municipio;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ViewScoped
public class MunicipioQuery extends BaseQueryController<Municipio> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1181359214684231966L;
	
	@EJB
	private MunicipioEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<Municipio> getQueryList() {
		return ejb.getAllMunicipios();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
	
}
