/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.HistoriaClinicaOncoEjb;
import com.isesalud.model.HistoriaClinicaOnco;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("HistoriaClinicaOncoConverter")
@RequestScoped
public class HistoriaClinicaOncoConverter extends AbstractConverter<HistoriaClinicaOnco, HistoriaClinicaOncoEjb>{

	@EJB
	private HistoriaClinicaOncoEjb manager;
	
	@Override
	protected HistoriaClinicaOncoEjb getCManager() {
		return this.manager;
	}

	
}
