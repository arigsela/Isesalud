/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

import com.isesalud.model.TipoEstudioCita;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Stateless
@LocalBean
public class TipoEstudioCitaPersistenceEjb extends BasePersistenceManagerEJB<TipoEstudioCita>{

	@Override
	public Class<TipoEstudioCita> getModelClass() {
		return TipoEstudioCita.class;
	}

}
