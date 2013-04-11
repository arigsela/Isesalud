/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Statuscita;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean
public class StatusCitaPersistenceEjb extends BasePersistenceManagerEJB<Statuscita>{

	@Override
	public Class<Statuscita> getModelClass() {
		return Statuscita.class;
	}

}
