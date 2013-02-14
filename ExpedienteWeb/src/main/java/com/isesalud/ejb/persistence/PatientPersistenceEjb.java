/**
 * 
 */
package com.isesalud.ejb.persistence;

import java.util.Date;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.isesalud.model.Paciente;
import com.isesalud.support.components.BasePersistenceManagerEJB;

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
	
	@Override
	protected void doBeforeAdd(Paciente model) throws EJBException {
		model.setDateCreated(new Date());
		model.setTimeCreated(new Date());
	}

}
