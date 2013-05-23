/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import com.isesalud.ejb.query.TipoTratamientoEjb;
import com.isesalud.model.TipoTratamiento;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("TipotraTamientoConverter")
@RequestScoped
public class TipoTratamientoConverter extends AbstractConverter<TipoTratamiento, TipoTratamientoEjb>{

	@EJB
	private TipoTratamientoEjb manager;

	@Override
	protected TipoTratamientoEjb getCManager() {
		return this.manager;
	}

}
