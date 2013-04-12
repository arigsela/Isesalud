/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Gabinete;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class GabinetePersistenceEjb extends BasePersistenceManagerEJB<Gabinete>{

	@Override
	public Class<Gabinete> getModelClass() {
		return Gabinete.class;
	}

}
