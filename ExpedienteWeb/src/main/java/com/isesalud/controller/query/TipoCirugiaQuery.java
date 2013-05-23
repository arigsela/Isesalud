/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.TipoCirugiaEjb;
import com.isesalud.model.TipoCirugia;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */

@Named
@RequestScoped
public class TipoCirugiaQuery extends BaseQueryController<TipoCirugia>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8594112868618413401L;
	@EJB
	private TipoCirugiaEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<TipoCirugia> getQueryList() {
		return ejb.getAllTiposCirugia();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
