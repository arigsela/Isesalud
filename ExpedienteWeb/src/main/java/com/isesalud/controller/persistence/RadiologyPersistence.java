/**
 * 
 */
package com.isesalud.controller.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import com.isesalud.controller.support.PatientSelection;
import com.isesalud.ejb.persistence.HallazgosPersistenceEjb;
import com.isesalud.ejb.persistence.ResultadoImagenPersistenceEjb;
import com.isesalud.model.Hallazgos;
import com.isesalud.model.ResultadoImagen;
import com.isesalud.support.components.BaseManagedCrudController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author ari
 *
 */
@Named
@ConversationScoped
public class RadiologyPersistence extends BaseManagedCrudController<ResultadoImagen, ResultadoImagenPersistenceEjb>{

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
	
	@EJB
	private HallazgosPersistenceEjb hallazgosPersistenceEjb;
	
	private Hallazgos hallazgos = new Hallazgos();
	
	private List<Hallazgos> hallazgosList = new ArrayList<Hallazgos>();
	
	public Hallazgos getHallazgos() {
		return hallazgos;
	}
	
	public void setHallazgos(Hallazgos hallazgos) {
		this.hallazgos = hallazgos;
	}
	
	public List<Hallazgos> getHallazgosList() {
		return hallazgosList;
	}
	public void setHallazgosList(List<Hallazgos> hallazgosList) {
		this.hallazgosList = hallazgosList;
	}
		
	public void addHallazgos(ActionEvent e){
		if(this.hallazgos.getName() != null && !this.hallazgos.getName().isEmpty()){
			this.hallazgos.setResultadoimagen(getModel());
			this.hallazgosList.add(hallazgos);
			this.hallazgos = new Hallazgos();
		}
	}
	
	public void eraseHallazgo(ActionEvent e){
		Hallazgos p = (Hallazgos) e.getComponent().getAttributes().get("selectHallazgo");
		eraseFromList(this.getHallazgosList(), this.hallazgosPersistenceEjb, p);
	}
	
	@Override
	protected ResultadoImagenPersistenceEjb getCrudManager() {
		return this.manager;
	}

	@Override
	protected void doAfterAdd() throws BaseException {
		if(conversation.isTransient())
			conversation.begin();
		getModel().setPaciente(this.patientSelection.getPaciente());
		getModel().setAdequate(true);
		getModel().setDaterealized(new Date());
		setOutcome("/radiologia/EstudioEntrada?faces-redirect=true");
		super.doAfterAdd();
	}
	
	@Override
	protected void doBeforeSave() throws BaseException {
		super.doBeforeSave();
		if (getModel().getAdequate()== true){ 
			getModel().setMotivoinadecuada(null);
		}
		getModel().setHallazgos(hallazgosList);
	}
	
	@Override
	protected void doAfterSave() throws BaseException {
		super.doAfterSave();
		if(!conversation.isTransient())
			conversation.end();
		setOutcome("/citas/Citas?faces-redirect=true");
	}
	
	@Override
	protected void doAfterCancel() throws BaseException {
		super.doAfterCancel();
		if(!conversation.isTransient())
			conversation.end();
		setOutcome("/citas/Citas?faces-redirect=true");
	}

	@Override
	protected ResultadoImagen getNewModel() {
		return new ResultadoImagen();
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
