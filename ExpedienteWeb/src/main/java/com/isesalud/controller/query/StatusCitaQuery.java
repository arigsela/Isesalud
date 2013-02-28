/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import com.isesalud.ejb.query.StatusCitaEjb;
import com.isesalud.model.Statuscita;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author Ing. Ari G. Sela M.
 *
 */
public class StatusCitaQuery extends BaseQueryController<Statuscita>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3310138780340119015L;
	
	@EJB
	private StatusCitaEjb ejb;
	
	@PostConstruct
	public void init(){
		setQueryListDM(getQueryList());
	}
	
	@Override
	protected List<Statuscita> getQueryList() {
		return ejb.getAllStatusCita();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

}
