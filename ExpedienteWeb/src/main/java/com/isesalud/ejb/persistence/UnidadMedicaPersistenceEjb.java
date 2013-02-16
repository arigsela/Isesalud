/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Unidadmedica;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class UnidadMedicaPersistenceEjb extends BasePersistenceManagerEJB<Unidadmedica>{

	@Override
	public Class<Unidadmedica> getModelClass() {
		return Unidadmedica.class;
	}
	

}
