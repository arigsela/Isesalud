/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

import com.isesalud.model.SintomaCancerMama;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class SintomaCancerMamaPersistenceEjb extends BasePersistenceManagerEJB<SintomaCancerMama>{

	@Override
	public Class<SintomaCancerMama> getModelClass() {
		return SintomaCancerMama.class;
	}

}
