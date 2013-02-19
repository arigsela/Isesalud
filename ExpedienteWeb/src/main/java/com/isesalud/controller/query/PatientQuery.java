/**
 * 
 */
package com.isesalud.controller.query;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.isesalud.ejb.query.PacienteEjb;
import com.isesalud.model.Paciente;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ViewScoped
public class PatientQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8753462146196584925L;

	private List<Paciente> model;
	
	private Paciente selectedPatient;
	
	@EJB
	private PacienteEjb pacienteEjb;
	
	public void query(ActionEvent e){
		model = pacienteEjb.getAllPatients();
	}
	
	
	public List<Paciente> getModel() {
		return model;
	}
	
	public void setModel(List<Paciente> model) {
		this.model = model;
	}
	
	public Paciente getSelectedPatient() {
		return selectedPatient;
	}
	
	public void setSelectedPatient(Paciente selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

}
