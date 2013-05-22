/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Tratamiento;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@LocalBean
@Stateless
public class TratamientoPersistenceEjb extends BasePersistenceManagerEJB<Tratamiento>{

	@Override
	public Class<Tratamiento> getModelClass() {
		return Tratamiento.class;
	}

	
}
