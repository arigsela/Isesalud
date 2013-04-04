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
import com.isesalud.ejb.persistence.CitaPersistenceEjb;
import com.isesalud.ejb.persistence.TipoEstudioCitaPersistenceEjb;
import com.isesalud.model.Cita;
import com.isesalud.model.TipoEstudioCita;
import com.isesalud.model.Tipocita;
import com.isesalud.support.JSFUtil;
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
	
	@EJB
	private CitaPersistenceEjb manager;
	
	@EJB
	private TipoEstudioCitaPersistenceEjb tipoEstudioCitaPersistenceEjb;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private PatientSelection patientSelection;
	
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
		getModel().setPaciente(this.patientSelection.getPaciente());
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
	
	@Override
	public void add(ActionEvent actionEvent) {
		if(patientSelection.getPaciente() == null){
			JSFUtil.warn("Seleccione a un paciente primero");
			setOutcome(null);
			return;
		} 
		
		setOutcome("/citas/CapturaCita");
		super.add(actionEvent);
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
