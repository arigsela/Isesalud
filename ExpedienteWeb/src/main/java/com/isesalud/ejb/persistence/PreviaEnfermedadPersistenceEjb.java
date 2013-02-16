/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.PreviaEnfermedad;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class PreviaEnfermedadPersistenceEjb extends BasePersistenceManagerEJB<PreviaEnfermedad>{

	@Override
	public Class<PreviaEnfermedad> getModelClass() {
		return PreviaEnfermedad.class;
	}
	

}
