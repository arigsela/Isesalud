/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.TratamientoEjb;
import com.isesalud.model.Tratamiento;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("TratamientoConverter")
@RequestScoped
public class TratamientoConverter extends AbstractConverter<Tratamiento, TratamientoEjb>{

	@EJB
	private TratamientoEjb manager;
	
	@Override
	protected TratamientoEjb getCManager() {
		return this.manager;
	}

}
