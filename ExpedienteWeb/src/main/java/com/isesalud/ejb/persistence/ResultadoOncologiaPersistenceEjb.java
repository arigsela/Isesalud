/**
 * 
 */
package com.isesalud.ejb.persistence;

import com.isesalud.model.ResultadoOncologia;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
public class ResultadoOncologiaPersistenceEjb extends BasePersistenceManagerEJB<ResultadoOncologia>{

	@Override
	public Class<ResultadoOncologia> getModelClass() {
		return ResultadoOncologia.class;
	}

}
