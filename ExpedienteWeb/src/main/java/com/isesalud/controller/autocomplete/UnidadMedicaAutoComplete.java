/**
 * 
 */
package com.isesalud.controller.autocomplete;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.isesalud.controller.security.SecurityComponent;
import com.isesalud.ejb.query.UnidadMedicaEjb;
import com.isesalud.model.Unidadmedica;
import com.isesalud.support.components.BaseAutoCompleteComponent;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@RequestScoped
public class UnidadMedicaAutoComplete extends BaseAutoCompleteComponent<Unidadmedica, UnidadMedicaEjb> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3081396252691357474L;

	@EJB
	private UnidadMedicaEjb manager;
	
	@Inject
	private SecurityComponent securityComponent;
	
	@Override
	protected UnidadMedicaEjb getACManager() {
		return manager;
	}

	@Override
	protected List<Unidadmedica> getList(final String description) {
		Unidadmedica params = new Unidadmedica();
		params.setName(description);
		params.setMunicipio(securityComponent.getCurrentUser().getMunicipio());
		return manager.getUnidadMedicaByMunicipio(params);
	}

}
