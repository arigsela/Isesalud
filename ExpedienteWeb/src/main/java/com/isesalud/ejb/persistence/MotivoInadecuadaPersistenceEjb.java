/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.MotivoInadecuada;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class MotivoInadecuadaPersistenceEjb extends BasePersistenceManagerEJB<MotivoInadecuada>{

	@Override
	public Class<MotivoInadecuada> getModelClass() {
		return MotivoInadecuada.class;
	}

}
