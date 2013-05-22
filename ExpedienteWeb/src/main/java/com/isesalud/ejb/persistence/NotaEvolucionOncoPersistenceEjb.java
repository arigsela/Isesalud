/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.NotaEvolucionOnco;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class NotaEvolucionOncoPersistenceEjb extends BasePersistenceManagerEJB<NotaEvolucionOnco>{

	@Override
	public Class<NotaEvolucionOnco> getModelClass() {
		return NotaEvolucionOnco.class;
	}

}
