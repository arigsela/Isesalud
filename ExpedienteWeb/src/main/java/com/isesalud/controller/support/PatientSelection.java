/**
 * 
 */
package com.isesalud.controller.support;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

import com.isesalud.model.Paciente;
import com.isesalud.support.components.BaseComponent;


/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@SessionScoped
public class PatientSelection extends BaseComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2674450844040493768L;
	
	private Paciente paciente;
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void OnPatientSelectChanged(@Observes Paciente p){
		setPaciente(p);
	}

}
