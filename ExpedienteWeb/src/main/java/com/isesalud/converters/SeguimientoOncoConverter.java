/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.SeguimientoOncoEjb;
import com.isesalud.model.SeguimientoOnco;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("SeguimientoOncoConverter")
@RequestScoped
public class SeguimientoOncoConverter extends AbstractConverter<SeguimientoOnco, SeguimientoOncoEjb>{

	@EJB
	private SeguimientoOncoEjb manager;
	
	@Override
	protected SeguimientoOncoEjb getCManager() {
		return this.manager;
	}

}
