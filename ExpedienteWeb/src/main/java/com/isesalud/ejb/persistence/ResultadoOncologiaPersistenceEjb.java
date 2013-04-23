/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.ResultadoOncologia;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class ResultadoOncologiaPersistenceEjb extends BasePersistenceManagerEJB<ResultadoOncologia>{

	@Override
	public Class<ResultadoOncologia> getModelClass() {
		return ResultadoOncologia.class;
	}

}
