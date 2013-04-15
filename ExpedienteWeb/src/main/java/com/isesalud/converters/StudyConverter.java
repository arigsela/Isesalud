/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;

import javax.inject.Named;

import com.isesalud.converters.AbstractConverter;
import com.isesalud.ejb.query.StudyEjb;
import com.isesalud.model.Study;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@FacesConverter("StudyConverter")
@RequestScoped
public class StudyConverter extends AbstractConverter<Study, StudyEjb> {

	@EJB
	private StudyEjb manager;
	
	@Override
	protected StudyEjb getCManager() {
		return this.manager;
	}

}
