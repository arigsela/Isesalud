/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import com.isesalud.ejb.query.TipoEstadoActualPacienteoncoEjb;
import com.isesalud.model.TipoEstadoActualPacienteOnco;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("TipoEstadoActualPacienteoncoConverter")
@RequestScoped
public class TipoEstadoActualPacienteOncoConverter extends AbstractConverter<TipoEstadoActualPacienteOnco, TipoEstadoActualPacienteoncoEjb>{

	@EJB
	private TipoEstadoActualPacienteoncoEjb manager;
	
	@Override
	protected TipoEstadoActualPacienteoncoEjb getCManager() {
		return this.manager;
	}

}
