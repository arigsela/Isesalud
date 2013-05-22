/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.HistoriaClinicaOnco;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class HistoriaClinicaOncoPersistenceEjb extends BasePersistenceManagerEJB<HistoriaClinicaOnco>{

	@Override
	public Class<HistoriaClinicaOnco> getModelClass() {
		return HistoriaClinicaOnco.class;
	}

}
