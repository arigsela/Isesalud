/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.MunicipioEjb;
import com.isesalud.model.Municipio;

/**
 * @author Haysoos
 *
 */
@Named
@FacesConverter("MunicipioConverter")
@RequestScoped
public class MunicipioConverter extends AbstractConverter<Municipio, MunicipioEjb> {

	@EJB
	private MunicipioEjb manager;
	
	@Override
	protected MunicipioEjb getCManager() {
		return this.manager;
	}

}
