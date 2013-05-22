/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.LineaMedicamento;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class LineaMedicamentoPersistenceEjb extends BasePersistenceManagerEJB<LineaMedicamento>{

	@Override
	public Class<LineaMedicamento> getModelClass() {
		return LineaMedicamento.class;
	}

}
