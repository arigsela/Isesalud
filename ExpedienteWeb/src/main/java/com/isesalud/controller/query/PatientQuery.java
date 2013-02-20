/**
 * 
 */
package com.isesalud.controller.query;

import java.util.Date;
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
	
	private Date dateOfBirth;
	
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
		
		if(getSearchParams() != null){
			if(getSearchParams().getName().isEmpty())
				getSearchParams().setName("%");
			if(getSearchParams().getLastName().isEmpty())
				getSearchParams().setLastName("%");
			if(getSearchParams().getMaternalLastName().isEmpty())
				getSearchParams().setMaternalLastName("%");
			
			getSearchParams().setDateofBirth(dateOfBirth);
			
			clearSelected();
			super.query(e);
		} else{
			try {
				init();
			} catch (BaseException ex) {
				ex.printStackTrace();
			}
		}
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
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
