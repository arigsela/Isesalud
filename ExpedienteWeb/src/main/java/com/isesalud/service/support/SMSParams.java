/**
 * 
 */
package com.isesalud.service.support;

import com.isesalud.model.Paciente;
import com.isesalud.support.components.BaseComponent;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
public class SMSParams extends BaseComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4478893373491681023L;
	private String msg;
	private Paciente paciente;
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
