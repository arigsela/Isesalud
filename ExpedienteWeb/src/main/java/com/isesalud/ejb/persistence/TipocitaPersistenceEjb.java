/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Tipocita;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author Ing. Ari G. Sela M.
 *
 */

@Stateless
@LocalBean
public class TipocitaPersistenceEjb extends BasePersistenceManagerEJB<Tipocita>{

	@Override
	public Class<Tipocita> getModelClass() {
		return Tipocita.class;
	}
	
}
