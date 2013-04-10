/**
 * 
 */
package com.isesalud.controller.persistence;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.isesalud.controller.support.PatientSelection;
import com.isesalud.ejb.persistence.ResultadoImagenPersistenceEjb;
import com.isesalud.model.resultadoImagen;
import com.isesalud.support.components.BaseManagedCrudController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author ari
 *
 */
@Named
@ConversationScoped
public class RadiologyPersistence extends BaseManagedCrudController<resultadoImagen, ResultadoImagenPersistenceEjb>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8024022234714333867L;

	@Inject
	private Conversation conversation;
	
	@Inject
	private PatientSelection patientSelection;
	
	@EJB
	private ResultadoImagenPersistenceEjb manager;
	
	@Override
	protected ResultadoImagenPersistenceEjb getCrudManager() {
	return this.manager;
	}

	@Override
	protected void doAfterAdd() throws BaseException {
		if(conversation.isTransient())
			conversation.begin();
		getModel().setPaciente(this.patientSelection.getPaciente());
		setOutcome("/radiologia/RadiologiaEntradas?faces-redirect=true");
		super.doAfterAdd();
	}
		
	@Override
	protected resultadoImagen getNewModel() {
		return new resultadoImagen();
	}

	@Override
	protected String getAddRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getEditRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getDeleteRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getViewRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
