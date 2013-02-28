/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.StatusCitaEjb;
import com.isesalud.model.Statuscita;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("StatusCitaConverter")
@RequestScoped
public class StatusCitaConverter extends AbstractConverter<Statuscita, StatusCitaEjb>{
	@EJB
	private StatusCitaEjb manager;

	@Override
	protected StatusCitaEjb getCManager() {
		return this.manager;
	}
	
}
