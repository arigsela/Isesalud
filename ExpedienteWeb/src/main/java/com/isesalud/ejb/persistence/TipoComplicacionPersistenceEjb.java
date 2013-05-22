/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.TipoComplicacion;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoComplicacionPersistenceEjb extends BasePersistenceManagerEJB<TipoComplicacion>{

	@Override
	public Class<TipoComplicacion> getModelClass() {
		return TipoComplicacion.class;
	}

}
