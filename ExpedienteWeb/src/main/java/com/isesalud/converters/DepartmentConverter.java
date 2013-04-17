/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.DepartmentEjb;
import com.isesalud.model.Department;

/**
 * @author Ing. Ari G. Sela M.
 *
 */

@Named
@FacesConverter("TipoCitaConverter")
@RequestScoped
public class DepartmentConverter extends AbstractConverter<Department, DepartmentEjb>{

	@EJB
	private DepartmentEjb manager;
	
	@Override
	protected DepartmentEjb getCManager() {
		return this.manager;
	}

}
