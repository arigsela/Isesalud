/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.TNMOncoEjb;
import com.isesalud.model.TNMOnco;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("TNMOncoConverter")
@RequestScoped
public class TNMOncoConverter extends AbstractConverter<TNMOnco, TNMOncoEjb>{
	
	@EJB
	private TNMOncoEjb manager;

	@Override
	protected TNMOncoEjb getCManager() {
		return this.manager;
	}
	
	

}
