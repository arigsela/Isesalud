/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.NotaEvolucionOncoEjb;
import com.isesalud.model.NotaEvolucionOnco;

/**
 * @author ari
 *
 */

@Named
@FacesConverter("NotaEvolucionOncoConverter")
@RequestScoped
public class NotaEvolucionOncoConverter extends AbstractConverter<NotaEvolucionOnco, NotaEvolucionOncoEjb>{

	@EJB
	private NotaEvolucionOncoEjb manager;
	
	@Override
	protected NotaEvolucionOncoEjb getCManager() {
		return this.manager;
	}
	
	
}
