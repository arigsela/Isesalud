/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.isesalud.model.CancerOtrasPartes;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean
public class CancerOtrasPartesPersistenceEjb extends BasePersistenceManagerEJB<CancerOtrasPartes>{

	@Override
	public Class<CancerOtrasPartes> getModelClass() {
		return CancerOtrasPartes.class;
	}

}
