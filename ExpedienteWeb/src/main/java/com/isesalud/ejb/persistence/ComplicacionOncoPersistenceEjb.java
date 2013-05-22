/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.ComplicacionOnco;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class ComplicacionOncoPersistenceEjb extends BasePersistenceManagerEJB<ComplicacionOnco>{

	@Override
	public Class<ComplicacionOnco> getModelClass() {
		return ComplicacionOnco.class;
	}

}
