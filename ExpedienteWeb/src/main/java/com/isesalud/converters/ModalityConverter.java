/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.ModalityEjb;
import com.isesalud.model.Modality;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("ModalityConverter")
@RequestScoped
public class ModalityConverter extends AbstractConverter<Modality, ModalityEjb>{

	@EJB
	private ModalityEjb manager;

	@Override
	protected ModalityEjb getCManager() {
		return this.manager;
	}
	
	
}
