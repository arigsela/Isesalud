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
import com.isesalud.ejb.persistence.StudyPersistenceEjb;
import com.isesalud.model.Cita;
import com.isesalud.model.Department;
import com.isesalud.model.Study;
import com.isesalud.support.DateUtil;
import com.isesalud.support.JSFUtil;
import com.isesalud.support.components.BaseManagedCrudController;
import com.isesalud.support.exceptions.BaseException;
import com.isesalud.support.exceptions.OperationException;

/**
 * @author ari, Jesus Espinoza Hernandez
 * 
 */
@Named
@ConversationScoped
public class CitaPersistence extends
		BaseManagedCrudController<Cita, CitaPersistenceEjb> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8179534442377180931L;

	private int citaMinutesOffset;

	@EJB
	private CitaPersistenceEjb manager;

	@EJB
	private StudyPersistenceEjb studypersistenceejb;

	@Inject
	private Conversation conversation;

	@Inject
	private PatientSelection patientSelection;

	private Department selectedDepartment = new Department();

	private Study selectedStudy = new Study();

	private Date citaDate;

	public Study getSelectedStudy() {
		return selectedStudy;
	}

	public void setSelectedStudy(Study selectedStudy) {
		this.selectedStudy = selectedStudy;
	}

	public Department getSelectedDepartment() {
		return selectedDepartment;
	}

	public void setSelectedDepartment(Department selectedDepartment) {
		this.selectedDepartment = selectedDepartment;
	}

	public Date getCitaDate() {
		return citaDate;
	}

	public void setCitaDate(Date citaDate) {
		this.citaDate = citaDate;
	}

	public int getCitaMinutesOffset() {
		return citaMinutesOffset;
	}

	public void setCitaMinutesOffset(int citaMinutesOffset) {
		this.citaMinutesOffset = citaMinutesOffset;
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
	protected void init() {
		super.init();
	}

	@Override
	protected void doAfterAdd() throws BaseException {
		if (conversation.isTransient())
			conversation.begin();

		Date date = new Date();
		this.citaDate = DateUtil.addMinutes(date, citaMinutesOffset);
		getModel().setEnviadosms(false);
		getModel().setDate(new Date());
		getModel().setTime(new Date());
		getModel().setPaciente(this.patientSelection.getPaciente());
		super.doAfterAdd();
	}

	@Override
	protected void doAfterEdit() throws BaseException {
		super.doAfterEdit();
		if (conversation.isTransient())
			conversation.begin();
	}

	@Override
	protected void doBeforeSave() throws BaseException {
		if (!isStudySelected()) {
			setOutcome(null);
			throw new OperationException(
					"No se selecciono un estudio para la cita");
		}

		getModel().setDate(getCitaDate());
		getModel().setTime(getCitaDate());
		super.doBeforeSave();
	}

	@Override
	protected void doAfterSave() throws BaseException {
		super.doAfterSave();
		if (!conversation.isTransient())
			conversation.end();
		setOutcome("/citas/Citas?faces-redirect=true");
	}

	@Override
	protected void doAfterCancel() throws BaseException {
		super.doAfterCancel();
		if (!conversation.isTransient())
			conversation.end();
		setOutcome("/citas/Citas?faces-redirect=true");
	}

	@Override
	public void add(ActionEvent actionEvent) {
		if (patientSelection.getPaciente() == null) {
			JSFUtil.warn("Seleccione a un paciente primero");
			setOutcome("/pacientes/busqueda?faces-redirect=true");
			return;
		}

		setOutcome("/citas/CapturaCita");
		super.add(actionEvent);
	}

	public boolean isStudySelected() {
		return (getModel().getStudy() == null) ? false : true;
	}

	public void onAddStudy(ActionEvent e) {
		getModel().setStudy(selectedStudy);
	}

	public void onDeleteStudy(ActionEvent e) {
		getModel().setStudy(null);
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
