/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.ParienteCancerMama;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class ParienteCancerMamaPersistenceEjb extends BasePersistenceManagerEJB<ParienteCancerMama>{

	@Override
	public Class<ParienteCancerMama> getModelClass() {
		return ParienteCancerMama.class;
	}

}
