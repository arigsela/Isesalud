/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.ComplicacionOncoEjb;
import com.isesalud.model.ComplicacionOnco;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class ComplicacionOncoQuery extends BaseQueryController<ComplicacionOnco>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2420289204689863557L;
	@EJB
	private ComplicacionOncoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<ComplicacionOnco> getQueryList() {
		return ejb.getAllComplicacionesOnco();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

}
