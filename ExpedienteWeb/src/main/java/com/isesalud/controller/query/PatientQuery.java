/**
 * 
 */
package com.isesalud.controller.query;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.isesalud.controller.persistence.PatientPersistence;
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
	
	private Date dateOfBirth;
	
	@Inject
	private PatientPersistence patientPersistence;
	
	private Paciente detailsPaciente;
	
	@EJB
	private PacienteEjb pacienteEjb;
	
	
	@Override
	protected void init() throws BaseException {
		searchParams = new Paciente();
	}
	
	@Override
	public void query(ActionEvent e) {
		
		if(getSearchParams() != null){
			
			getSearchParams().setDateofBirth(dateOfBirth);
			
			super.query(e);
			
		} else{
			try {
				init();
			} catch (BaseException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void onSelectedRow(SelectEvent e){
		detailsPaciente = pacienteEjb.getFULL(patientPersistence.getModel().getId());
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
	
	public Paciente getDetailsPaciente() {
		return detailsPaciente;
	}
	
	public void setDetailsPaciente(Paciente detailsPaciente) {
		this.detailsPaciente = detailsPaciente;
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
