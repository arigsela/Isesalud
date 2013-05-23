/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.ComplicacionOncoEjb;
import com.isesalud.model.ComplicacionOnco;

/**
 * @author ari
 *
 */

@Named
@FacesConverter("ComplicacionOncoConverter")
@RequestScoped
public class ComplicacionOncoConverter extends AbstractConverter<ComplicacionOnco, ComplicacionOncoEjb>{
	
	@EJB
	private ComplicacionOncoEjb manager;

	@Override
	protected ComplicacionOncoEjb getCManager() {
		return this.manager;
	}
	
	

}
