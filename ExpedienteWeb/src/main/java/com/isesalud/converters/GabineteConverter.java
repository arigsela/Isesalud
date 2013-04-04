/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import com.isesalud.ejb.query.GabineteEjb;
import com.isesalud.model.Gabinete;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("GabineteConverter")
@RequestScoped

public class GabineteConverter extends AbstractConverter<Gabinete, GabineteEjb>{

	@EJB
	private GabineteEjb manager;
	
	@Override
	protected GabineteEjb getCManager() {
		return this.manager;
	}

}
