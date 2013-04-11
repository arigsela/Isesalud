/**
 * 
 */
package com.isesalud.controller.application;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.isesalud.ejb.persistence.SystemSettingsPersistenceEjb;
import com.isesalud.model.SystemSettings;
import com.isesalud.support.components.BaseManagedCrudController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ApplicationScoped
public class ApplicationSettings extends BaseManagedCrudController<SystemSettings, SystemSettingsPersistenceEjb> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5024551459880504638L;
	
	@EJB
	private SystemSettingsPersistenceEjb manager;
	
	/*
	 * Load the first system profile. It must exist or there will be hell to pay
	 */
	@PostConstruct
	public void loadSystemProfile(){
		setModel(manager.get(1L));
	}
	
	@Override
	public void clear() throws BaseException {
		//Disable clear function. We will manage the entity ourselves.
	}

	@Override
	protected SystemSettingsPersistenceEjb getCrudManager() {
		return manager;
	}

	@Override
	protected SystemSettings getNewModel() {
		return new SystemSettings();
	}
	
	@Override
	protected void doAfterSave() throws BaseException {
		loadSystemProfile();
		super.doAfterSave();
	}
	
	@Override
	public void add(ActionEvent actionEvent) {
		// NOT IMPLEMENTED YET, SO DISABLE ADDING NEW PROFILES
		//super.add(actionEvent);
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
