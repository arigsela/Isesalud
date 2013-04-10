/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.isesalud.controller.security.SecurityComponent;
import com.isesalud.ejb.query.UnidadMedicaEjb;
import com.isesalud.model.Unidadmedica;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */

@Named
@ViewScoped
public class UnidadMedicaQuery extends BaseQueryController<Unidadmedica>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 657389857857837982L;
	
	@EJB
	private UnidadMedicaEjb ejb;
	
	@Inject
	private SecurityComponent securityComponent;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}	

	@Override
	protected List<Unidadmedica> getQueryList() {
		Unidadmedica params = new Unidadmedica();
		params.setMunicipio(securityComponent.getCurrentUser().getMunicipio());
		return ejb.getUnidadMedicaByMunicipio(params);
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
