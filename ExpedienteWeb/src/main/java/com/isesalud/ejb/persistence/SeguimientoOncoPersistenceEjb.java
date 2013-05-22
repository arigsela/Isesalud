/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.SeguimientoOnco;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class SeguimientoOncoPersistenceEjb extends BasePersistenceManagerEJB<SeguimientoOnco>{

	@Override
	public Class<SeguimientoOnco> getModelClass() {
		return SeguimientoOnco.class;
	}

}
