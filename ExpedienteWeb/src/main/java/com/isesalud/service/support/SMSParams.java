/**
 * 
 */
package com.isesalud.service.support;

import com.isesalud.model.Cita;
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
	private Cita cita;
	
	public Cita getCita() {
		return cita;
	}
	
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
