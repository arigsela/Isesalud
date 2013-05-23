/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.MedicamentoprescritoEjb;
import com.isesalud.model.MedicamentoPrescrito;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("MedicamentoPrescritoConverter")
@RequestScoped
public class MedicamentoPrescritoConverter extends AbstractConverter<MedicamentoPrescrito, MedicamentoprescritoEjb>{

	@EJB
	private MedicamentoprescritoEjb manager;

	@Override
	protected MedicamentoprescritoEjb getCManager() {
		return this.manager;
	}

}
