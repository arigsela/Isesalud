/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.isesalud.ejb.query.PacienteEjb;

import com.isesalud.model.Paciente;

/**
 * @author Haysoos
 *
 */
@Named
@RequestScoped
public class PatientQuery {

	private List<Paciente> model;
	
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

}
