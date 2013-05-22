/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.TipoTratamiento;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoTratamientoPersistenceEjb extends BasePersistenceManagerEJB<TipoTratamiento>{

	@Override
	public Class<TipoTratamiento> getModelClass() {
		return TipoTratamiento.class;
	}
	
	
}
