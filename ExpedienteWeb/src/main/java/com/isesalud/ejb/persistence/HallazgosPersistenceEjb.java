/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Hallazgos;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean
public class HallazgosPersistenceEjb extends BasePersistenceManagerEJB<Hallazgos>{

	@Override
	public Class<Hallazgos> getModelClass() {
	return Hallazgos.class;
	}

}
