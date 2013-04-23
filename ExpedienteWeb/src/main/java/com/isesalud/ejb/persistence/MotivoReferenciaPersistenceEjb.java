/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.MotivoReferencia;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean
public class MotivoReferenciaPersistenceEjb extends BasePersistenceManagerEJB<MotivoReferencia>{

	@Override
	public Class<MotivoReferencia> getModelClass() {
		return MotivoReferencia.class;
	}

}
