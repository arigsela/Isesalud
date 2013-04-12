/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import com.isesalud.ejb.query.HallazgosEjb;
import com.isesalud.model.Hallazgos;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("HallazgosConverter")
@RequestScoped
public class HallazgosConverter extends AbstractConverter<Hallazgos, HallazgosEjb>{

	@EJB
	private HallazgosEjb manager;
	
	@Override
	protected HallazgosEjb getCManager() {
	return this.manager;
	}

}
