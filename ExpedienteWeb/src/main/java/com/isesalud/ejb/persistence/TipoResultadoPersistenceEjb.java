/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.TipoResultado;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoResultadoPersistenceEjb extends BasePersistenceManagerEJB<TipoResultado>{

	@Override
	public Class<TipoResultado> getModelClass() {
		return TipoResultado.class;
	}

}
