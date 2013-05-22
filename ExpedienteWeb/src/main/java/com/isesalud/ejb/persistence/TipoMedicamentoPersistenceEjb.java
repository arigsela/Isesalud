/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.isesalud.model.TipoMedicamento;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class TipoMedicamentoPersistenceEjb extends BasePersistenceManagerEJB<TipoMedicamento>{

	@Override
	public Class<TipoMedicamento> getModelClass() {
		return TipoMedicamento.class;
	}

	
}
