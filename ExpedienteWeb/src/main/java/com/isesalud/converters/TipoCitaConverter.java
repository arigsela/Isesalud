/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.TipocitaEjb;
import com.isesalud.model.Tipocita;

/**
 * @author Ing. Ari G. Sela M.
 *
 */

@Named
@FacesConverter("TipoCitaConverter")
@RequestScoped
public class TipoCitaConverter extends AbstractConverter<Tipocita, TipocitaEjb>{

	@EJB
	private TipocitaEjb manager;
	
	@Override
	protected TipocitaEjb getCManager() {
		return this.manager;
	}

}
