/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

import com.isesalud.model.Study;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Stateless
@LocalBean
public class StudyPersistenceEjb extends BasePersistenceManagerEJB<Study>{

	@Override
	public Class<Study> getModelClass() {
		return Study.class;
	}

}
