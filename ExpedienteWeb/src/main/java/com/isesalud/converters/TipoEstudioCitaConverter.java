/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;

import javax.inject.Named;

import com.isesalud.converters.AbstractConverter;
import com.isesalud.ejb.query.TipoEstudioCitaEjb;
import com.isesalud.model.TipoEstudioCita;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@FacesConverter("TipoEstudioCitaConverter")
@RequestScoped
public class TipoEstudioCitaConverter extends AbstractConverter<TipoEstudioCita, TipoEstudioCitaEjb> {

	@EJB
	private TipoEstudioCitaEjb manager;
	
	@Override
	protected TipoEstudioCitaEjb getCManager() {
		return this.manager;
	}

}
