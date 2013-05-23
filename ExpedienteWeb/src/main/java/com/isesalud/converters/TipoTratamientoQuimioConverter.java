/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;

import javax.inject.Named;

import com.isesalud.ejb.query.TipoTratamientoQuimioEjb;
import com.isesalud.model.TipoTratamientoQuimio;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("TipoTratamientoQuimioConverter")
@RequestScoped
public class TipoTratamientoQuimioConverter extends AbstractConverter<TipoTratamientoQuimio, TipoTratamientoQuimioEjb>{

	@EJB
	private TipoTratamientoQuimioEjb manager;
	
	@Override
	protected TipoTratamientoQuimioEjb getCManager() {
		return this.manager;
	}

}
