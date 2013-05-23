/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.TipoMedicamentoEjb;
import com.isesalud.model.TipoMedicamento;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("TipoMedicamentoConverter")
@RequestScoped
public class TipoMedicamentoConverter extends AbstractConverter<TipoMedicamento, TipoMedicamentoEjb>{

	@EJB
	private TipoMedicamentoEjb manager;
	
	@Override
	protected TipoMedicamentoEjb getCManager() {
		return this.manager;
	}

}
