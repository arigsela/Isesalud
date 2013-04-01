/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.RoleEjb;
import com.isesalud.model.Role;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@FacesConverter("RoleConverter")
@RequestScoped
public class RoleConverter extends AbstractConverter<Role, RoleEjb> {

	@EJB
	private RoleEjb manager;
	
	@Override
	protected RoleEjb getCManager() {
		return this.manager;
	}

}
