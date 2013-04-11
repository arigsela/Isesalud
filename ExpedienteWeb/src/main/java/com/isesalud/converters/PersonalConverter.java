package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.PersonalEjb;
import com.isesalud.model.Personal;

/**
 * @author Haysoos
 *
 */
@Named
@FacesConverter("PersonalConverter")
@RequestScoped
public class PersonalConverter extends AbstractConverter<Personal, PersonalEjb> {

	@EJB
	private PersonalEjb manager;
	
	@Override
	protected PersonalEjb getCManager() {
		return this.manager;
	}

}
