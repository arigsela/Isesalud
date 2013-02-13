/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.UnidadMedicaEjb;
import com.isesalud.model.Unidadmedica;

/**
 * @author Haysoos
 *
 */
@Named
@FacesConverter("UnidadMedicaConverter")
@RequestScoped
public class UnidadMedicaConverter extends AbstractConverter<Unidadmedica, UnidadMedicaEjb> {

	@EJB
	private UnidadMedicaEjb manager;
	
	@Override
	protected UnidadMedicaEjb getCManager() {
		return this.manager;
	}

}
