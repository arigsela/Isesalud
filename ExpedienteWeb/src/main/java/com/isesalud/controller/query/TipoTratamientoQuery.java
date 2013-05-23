/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.TipoTratamientoEjb;
import com.isesalud.model.TipoTratamiento;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class TipoTratamientoQuery extends BaseQueryController<TipoTratamiento>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 435157698099109032L;
	@EJB
	private TipoTratamientoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<TipoTratamiento> getQueryList() {
		return ejb.getAllTiposTratamiento();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
