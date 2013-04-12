/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Modality;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean
public class ModalityPersistenceEjb extends BasePersistenceManagerEJB<Modality>{

	@Override
	public Class<Modality> getModelClass() {
		return Modality.class;
	}

	
}
