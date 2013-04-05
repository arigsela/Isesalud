/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.resultadoImagen;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class ResultadoImagenPersistenceEjb extends BasePersistenceManagerEJB<resultadoImagen>{

	@Override
	public Class<resultadoImagen> getModelClass() {
		return resultadoImagen.class;
	}

}
