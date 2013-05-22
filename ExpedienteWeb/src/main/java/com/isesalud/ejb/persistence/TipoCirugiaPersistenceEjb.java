/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.TipoCirugia;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoCirugiaPersistenceEjb extends BasePersistenceManagerEJB<TipoCirugia>{

	@Override
	public Class<TipoCirugia> getModelClass() {
		return TipoCirugia.class;
		}

}
