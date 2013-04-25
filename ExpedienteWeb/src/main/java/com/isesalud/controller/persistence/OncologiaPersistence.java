/**
 * 
 */
package com.isesalud.controller.persistence;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.isesalud.controller.support.PatientSelection;
import com.isesalud.ejb.persistence.ResultadoOncologiaPersistenceEjb;
import com.isesalud.model.ResultadoOncologia;
import com.isesalud.support.JSFUtil;
import com.isesalud.support.components.BaseManagedCrudController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ConversationScoped
public class OncologiaPersistence extends BaseManagedCrudController<ResultadoOncologia, ResultadoOncologiaPersistenceEjb> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9102340724994714941L;
	
	@EJB
	private ResultadoOncologiaPersistenceEjb manager;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private PatientSelection patientSelection;
	
	@Override
	public void add(ActionEvent actionEvent) {
		if (patientSelection.getPaciente() == null) {
			JSFUtil.warn("Seleccione a un paciente primero");
			setOutcome("/pacientes/busqueda?faces-redirect=true");
			return;
		}
		
		setOutcome("/oncologia/OncoEntrada?faces-redirect=true");
		
		super.add(actionEvent);
	}
	
	@Override
	protected void doAfterAdd() throws BaseException {
		if(conversation.isTransient()){
			conversation.begin();
		}
		
		getModel().setPaciente(patientSelection.getPaciente());
		getModel().setDateSampleTaken(new Date());
		super.doAfterAdd();
	}
	
	@Override
	protected void doBeforeSave() throws BaseException {
		super.doBeforeSave();
		getModel().setTimeOfCreation(new Date());
	}
	
	@Override
	protected void doAfterSave() throws BaseException {
		super.doAfterSave();
		if(!conversation.isTransient()){
			conversation.end();
		}
		setOutcome("/citas/Citas?faces-redirect=true");
	}
	
	@Override
	protected void doAfterCancel() throws BaseException {
		super.doAfterCancel();
		setOutcome("/citas/Citas?faces-redirect=true");
	}

	@Override
	protected ResultadoOncologiaPersistenceEjb getCrudManager() {
		return this.manager;
	}

	@Override
	protected ResultadoOncologia getNewModel() {
		return new ResultadoOncologia();
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
