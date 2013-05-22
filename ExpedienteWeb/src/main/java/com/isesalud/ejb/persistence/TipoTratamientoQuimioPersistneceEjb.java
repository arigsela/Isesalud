/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

import com.isesalud.model.TipoTratamientoQuimio;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoTratamientoQuimioPersistneceEjb extends BasePersistenceManagerEJB<TipoTratamientoQuimio>{

	@Override
	public Class<TipoTratamientoQuimio> getModelClass() {
		return TipoTratamientoQuimio.class;
	}

}
