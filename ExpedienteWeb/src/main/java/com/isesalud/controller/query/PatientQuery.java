/**
 * 
 */
package com.isesalud.controller.query;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.isesalud.controller.support.PatientSelection;
import com.isesalud.ejb.query.PacienteEjb;
import com.isesalud.model.Paciente;
import com.isesalud.support.CompareUtil;
import com.isesalud.support.JSFUtil;
import com.isesalud.support.components.BaseQueryController;
import com.isesalud.support.exceptions.BaseException;
import com.isesalud.support.exceptions.OperationException;

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
	
	@Inject
	private PatientSelection patientSelection;
	
	@Inject @Any
	private Event<Paciente> patientSelectedEvent;
	
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
			try{
				if(CompareUtil.isEmpty(getSearchParams().getName()) &&
				   CompareUtil.isEmpty(getSearchParams().getLastName()) &&
				   CompareUtil.isEmpty(getSearchParams().getMaternalLastName()) &&
				   CompareUtil.isEmpty(getSearchParams().getUnidadmedica()) &&
				   CompareUtil.isEmpty(getSearchParams().getDateofBirth())){
							
					throw new OperationException("Seleccione por lo menos un campo de busqueda");
				} else {
					getSearchParams().setDateofBirth(dateOfBirth);
					super.query(e);
				}
			}catch (BaseException ex){
				JSFUtil.error(ex.getMessages());
			}
		} else{
			try {
				init();
			} catch (BaseException ex) {
				log.error(ex.getMessage());
			}
		}
	}
	
	public void onSelectedRow(SelectEvent e){
		detailsPaciente = pacienteEjb.getFULL(getSelectedPatient().getId());
		patientSelectedEvent.fire(detailsPaciente);
	}
	
	public Paciente getSearchParams() {
		return searchParams;
	}
	
	public void setSearchParams(Paciente searchParams) {
		this.searchParams = searchParams;
	}
	
	public Paciente getSelectedPatient() {
		return selectedPatient;
	}
	
	public void setSelectedPatient(Paciente selectedPatient) {
		this.selectedPatient = selectedPatient;
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
