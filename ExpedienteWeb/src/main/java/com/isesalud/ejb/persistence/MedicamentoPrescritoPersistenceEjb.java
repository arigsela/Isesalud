/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

import com.isesalud.model.MedicamentoPrescrito;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class MedicamentoPrescritoPersistenceEjb extends BasePersistenceManagerEJB<MedicamentoPrescrito>{

	@Override
	public Class<MedicamentoPrescrito> getModelClass() {
		return MedicamentoPrescrito.class;
	}

	
}
