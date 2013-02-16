package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Municipio;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * 
 * @author ari
 *
 */
@Stateless
@LocalBean
public class MunicipioPersistenceEjb extends BasePersistenceManagerEJB<Municipio> {

	@Override
	public Class<Municipio> getModelClass() {
		return Municipio.class;
	}

}
