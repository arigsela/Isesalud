/**
 * 
 */
package com.isesalud.controller.persistence;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Observes;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.solder.logging.Logger;

import com.isesalud.ejb.persistence.CitaPersistenceEjb;
import com.isesalud.ejb.persistence.TipoEstudioCitaPersistenceEjb;
import com.isesalud.model.Cita;
import com.isesalud.model.Paciente;
import com.isesalud.model.TipoEstudioCita;
import com.isesalud.model.Tipocita;
import com.isesalud.support.components.BaseManagedCrudController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author ari, Jesus Espinoza Hernandez
 *
 */
@Named
@ConversationScoped
public class CitaPersistence extends BaseManagedCrudController<Cita, CitaPersistenceEjb> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8179534442377180931L;
	
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(getClass());
	
	@EJB
	private CitaPersistenceEjb manager;
	
	@EJB
	private TipoEstudioCitaPersistenceEjb tipoEstudioCitaPersistenceEjb;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private PatientPersistence patientPersistence;
	
	private Tipocita selectedTipocita = new Tipocita();
	
	private TipoEstudioCita selectedStudy = new TipoEstudioCita();
	
	public TipoEstudioCita getSelectedStudy() {
		return selectedStudy;
	}
	
	public void setSelectedStudy(TipoEstudioCita selectedStudy) {
		this.selectedStudy = selectedStudy;
	}
	
	public Tipocita getSelectedTipocita() {
		return selectedTipocita;
	}
	
	public void setSelectedTipocita(Tipocita selectedTipocita) {
		this.selectedTipocita = selectedTipocita;
	}

	@Override
	protected CitaPersistenceEjb getCrudManager() {
		return this.manager;
	}

	@Override
	protected Cita getNewModel() {
		return new Cita();
	}
	
	@Override
	protected void doAfterAdd() throws BaseException {
		if(conversation.isTransient())
			conversation.begin();
		getModel().setEnviadosms(false);
		getModel().setDate(new Date());
		getModel().setTime(new Date());
		getModel().setPaciente(this.patientPersistence.getModel());
		super.doAfterAdd();
	}
	
	@Override
	protected void doAfterEdit() throws BaseException {
		super.doAfterEdit();
		if(conversation.isTransient())
			conversation.begin();
	}
	
	@Override
	protected void doBeforeSave() throws BaseException {
		super.doBeforeSave();
		
	}
	
	@Override
	protected void doAfterSave() throws BaseException {
		super.doAfterSave();
		if(!conversation.isTransient())
			conversation.end();
	}
	
	@Override
	protected void doAfterCancel() throws BaseException {
		super.doAfterCancel();
		if(!conversation.isTransient())
			conversation.end();
	}
	
	public boolean isStudySelected(){
		return (getModel().getTipoestudiocita() == null) ? false : true;
	}
	
	public void onAddStudy(ActionEvent e){
		getModel().setTipoestudiocita(selectedStudy);
	}
	
	public void onDeleteStudy(ActionEvent e){
		getModel().setTipoestudiocita(null);
	}
	
	public void onPatientSelected(@Observes Paciente p){
		getModel().setPaciente(p);
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
