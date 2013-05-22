/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.TipoEstadoActualPacienteOnco;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@LocalBean
@Stateless
public class TipoEstadoActualPacienteOncoPersistenceEjb extends BasePersistenceManagerEJB<TipoEstadoActualPacienteOnco>{

	@Override
	public Class<TipoEstadoActualPacienteOnco> getModelClass() {
		return TipoEstadoActualPacienteOnco.class;
	}

	
}
