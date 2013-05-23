/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.TipoCirugiaEjb;
import com.isesalud.model.TipoCirugia;

/**
 * @author ari
 *
 */

@Named
@FacesConverter("TipoCirugiaConverter")
@RequestScoped
public class TipoCirugiaConverter extends AbstractConverter<TipoCirugia, TipoCirugiaEjb>{

	@EJB
	private TipoCirugiaEjb manager;
	
	@Override
	protected TipoCirugiaEjb getCManager() {
		return this.manager;
	}

}
