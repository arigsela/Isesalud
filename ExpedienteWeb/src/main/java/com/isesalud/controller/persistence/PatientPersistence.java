/**
 * 
 */
package com.isesalud.controller.persistence;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.isesalud.ejb.persistence.PatientPersistenceEjb;
import com.isesalud.model.Paciente;
import com.isesalud.support.components.BaseManagedCrudController;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ViewScoped
public class PatientPersistence extends BaseManagedCrudController<Paciente, PatientPersistenceEjb> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8376685298021320691L;
	
	@EJB
	private PatientPersistenceEjb manager;
	
	public String navigate(){
		return "home";
	}

	@Override
	protected PatientPersistenceEjb getCrudManager() {
		return this.manager;
	}

	@Override
	protected Paciente getNewModel() {
		return new Paciente();
	}

	@Override
	protected String getAddRole() {
		return null;
	}

	@Override
	protected String getEditRole() {
		return null;
	}

	@Override
	protected String getDeleteRole() {
		return null;
	}

	@Override
	protected String getViewRole() {
		return null;
	}

}
