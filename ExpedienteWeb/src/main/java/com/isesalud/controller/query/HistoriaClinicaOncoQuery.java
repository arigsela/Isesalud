/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.HistoriaClinicaOncoEjb;
import com.isesalud.model.HistoriaClinicaOnco;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class HistoriaClinicaOncoQuery extends BaseQueryController<HistoriaClinicaOnco>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6764753786057739484L;
	@EJB
	private HistoriaClinicaOncoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<HistoriaClinicaOnco> getQueryList() {
		return ejb.getAllHistoriasClinicasOnco();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
