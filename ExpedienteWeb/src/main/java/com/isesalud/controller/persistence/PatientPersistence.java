/**
 * 
 */
package com.isesalud.controller.persistence;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.isesalud.ejb.persistence.PatientPersistenceEjb;
import com.isesalud.model.Paciente;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@SessionScoped
public class PatientPersistence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8376685298021320691L;
	
	private Paciente paciente;
	
	@PostConstruct
	public void init(){
		paciente = new Paciente();
	}
	
	@EJB
	private PatientPersistenceEjb manager;
	
	public void savePaciente(ActionEvent e){
		if(paciente != null){
			manager.save(paciente);
		}
		
		init();
	}
	
	public String navigate(){
		return "home";
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
