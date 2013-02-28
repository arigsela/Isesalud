/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Cita;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean

public class CitaPersistenceEjb extends BasePersistenceManagerEJB<Cita> {

	
	
	@Override
	public Class<Cita> getModelClass() {
		return Cita.class;
	}
	
}
