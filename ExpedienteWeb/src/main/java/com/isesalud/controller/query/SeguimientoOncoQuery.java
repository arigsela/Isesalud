/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.SeguimientoOncoEjb;
import com.isesalud.model.SeguimientoOnco;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class SeguimientoOncoQuery extends BaseQueryController<SeguimientoOnco>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6267900749324045000L;
	@EJB
	private SeguimientoOncoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<SeguimientoOnco> getQueryList() {
		return ejb.getAllSeguimientosOnco();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
