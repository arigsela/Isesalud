/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Paciente;

/**
 * @author Haysoos
 *
 */
@Stateless
@LocalBean
public class PatientPersistenceEjb extends BasePersistenceManagerEJB<Paciente> {

	@Override
	public Class<Paciente> getModelClass() {
		return Paciente.class;
	}

}
