/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.isesalud.model.Entidad;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class EntidadPersistenceEjb extends BasePersistenceManagerEJB<Entidad>{

	@Override
	public Class<Entidad> getModelClass() {
		return Entidad.class;
	}
}
