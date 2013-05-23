/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import com.isesalud.ejb.query.TipoLineaMedicamentoEjb;
import com.isesalud.model.TipoLineaMedicamento;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("TipoLineaMedicaConverter")
@RequestScoped
public class TipoLineaMedicamentoConverter extends AbstractConverter<TipoLineaMedicamento, TipoLineaMedicamentoEjb>{

	@EJB
	private TipoLineaMedicamentoEjb manager;
	
	@Override
	protected TipoLineaMedicamentoEjb getCManager() {
		return this.manager;
	}

}
