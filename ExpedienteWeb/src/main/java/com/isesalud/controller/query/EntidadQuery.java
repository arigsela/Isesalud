
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.isesalud.ejb.query.EntidadEjb;
import com.isesalud.model.Entidad;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author Ing. Ari G. Sela M.
 *
 */
@Named
@ViewScoped
public class EntidadQuery extends BaseQueryController<Entidad>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2759413130089706085L;
	
	@EJB
	private EntidadEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<Entidad> getQueryList() {
		return ejb.getAllEntidades();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

}
