/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Personal;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class PersonalPersistenceEjb extends BasePersistenceManagerEJB<Personal>{

	@Override
	public Class<Personal> getModelClass() {
		return Personal.class;
	}

}
