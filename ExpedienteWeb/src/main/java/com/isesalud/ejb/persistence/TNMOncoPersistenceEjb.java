/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.TNMOnco;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TNMOncoPersistenceEjb extends BasePersistenceManagerEJB<TNMOnco>{

	@Override
	public Class<TNMOnco> getModelClass() {
		return TNMOnco.class;
	}

}
