/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.TratamientoEjb;
import com.isesalud.model.Tratamiento;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class TratamientoQuery extends BaseQueryController<Tratamiento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7937331960601786576L;
	@EJB
	private TratamientoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<Tratamiento> getQueryList() {
		return ejb.getAllTratamientos();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
