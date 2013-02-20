/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.isesalud.ejb.query.PacienteEjb;
import com.isesalud.model.Paciente;
import com.isesalud.support.components.BaseQueryController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ViewScoped
public class PatientQuery extends BaseQueryController<Paciente> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8753462146196584925L;
	
	private Paciente searchParams;
	
	private Paciente selectedPatient;
	
	@EJB
	private PacienteEjb pacienteEjb;
	
	@Override
	protected void init() throws BaseException {
		searchParams = new Paciente();
	}
	
	public void showPatientDetails(ActionEvent e){
		Paciente p = (Paciente) e.getComponent().getAttributes().get("detail");
		Paciente full = pacienteEjb.getFULL(p.getId());
		setSelectedPatient(full);
	}
	
	public Paciente getSelectedPatient() {
		return selectedPatient;
	}
	
	@Override
	public void query(ActionEvent e) {
		if(getSearchParams().getName().isEmpty())
			getSearchParams().setName("%");
		if(getSearchParams().getLastName().isEmpty())
			getSearchParams().setLastName("%");
		if(getSearchParams().getMaternalLastName().isEmpty())
			getSearchParams().setMaternalLastName("%");
		
		clearSelected();
		super.query(e);
	}
	
	public void clearSelected(){
		selectedPatient = null;
	}
	
	public void setSelectedPatient(Paciente selectedPatient) {
		this.selectedPatient = selectedPatient;
	}
	
	public Paciente getSearchParams() {
		return searchParams;
	}
	
	public void setSearchParams(Paciente searchParams) {
		this.searchParams = searchParams;
	}

	@Override
	protected List<Paciente> getQueryList() {
		return pacienteEjb.getPatients(this.searchParams);
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

}
