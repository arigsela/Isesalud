/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.TipoTratamientoQuimioEjb;
import com.isesalud.model.TipoTratamientoQuimio;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class TipoTratamientoQuimioQuery extends BaseQueryController<TipoTratamientoQuimio>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1325754425172052704L;
	@EJB
	private TipoTratamientoQuimioEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<TipoTratamientoQuimio> getQueryList() {
		return ejb.getAllTiposTratamientoQuimio();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
