/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.CitaEjb;
import com.isesalud.model.Cita;

/**
 * @author Ing. Ari G. Sela M.
 *
 */
@Named
@FacesConverter("CitaConverter")
@RequestScoped

public class CitaConverter extends AbstractConverter<Cita, CitaEjb>{

	@EJB
	private CitaEjb manager; 
	
	@Override
	protected CitaEjb getCManager() {
	return this.manager;
	}

}
