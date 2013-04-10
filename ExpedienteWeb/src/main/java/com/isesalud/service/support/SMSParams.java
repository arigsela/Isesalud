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
	private static final long serialVersionUID = -6798880532949381037L;
	private String msg;
	private boolean nextDayMsg;
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
	
	public boolean isNextDayMsg() {
		return nextDayMsg;
	}
	
	public void setNextDayMsg(boolean nextDayMsg) {
		this.nextDayMsg = nextDayMsg;
	}
}
