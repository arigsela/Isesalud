/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.ResultadoImagen;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class ResultadoImagenPersistenceEjb extends BasePersistenceManagerEJB<ResultadoImagen>{

	@Override
	public Class<ResultadoImagen> getModelClass() {
		return ResultadoImagen.class;
	}

}
