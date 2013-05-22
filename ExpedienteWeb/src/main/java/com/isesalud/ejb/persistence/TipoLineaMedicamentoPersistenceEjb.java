/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.TipoLineaMedicamento;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoLineaMedicamentoPersistenceEjb extends BasePersistenceManagerEJB<TipoLineaMedicamento>{

	@Override
	public Class<TipoLineaMedicamento> getModelClass() {
		return TipoLineaMedicamento.class;
	}

}
