/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import com.isesalud.ejb.query.LineaMedicamentoEjb;
import com.isesalud.model.LineaMedicamento;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("LineaMedicamentoConverter")
@RequestScoped
public class LineaMedicamentoConverter extends AbstractConverter<LineaMedicamento, LineaMedicamentoEjb>{

	@EJB
	private LineaMedicamentoEjb manager;

	@Override
	protected LineaMedicamentoEjb getCManager() {
		return this.manager;
	}
	
	
}
