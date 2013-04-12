/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.EntidadEjb;
import com.isesalud.model.Entidad;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("EntidadConverter")
@RequestScoped
public class EntidadConverter extends AbstractConverter<Entidad, EntidadEjb>{

	@EJB
	private EntidadEjb manager;

	@Override
	protected EntidadEjb getCManager() {
		return this.manager;
	}
	
	
	
}
