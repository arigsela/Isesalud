/**
 * 
 */
package com.isesalud.controller.query;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.isesalud.ejb.query.CitaEjb;
import com.isesalud.model.Cita;
import com.isesalud.support.components.BaseQueryController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@ViewScoped
public class CitaDayReportQuery extends BaseQueryController<Cita>{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4521548256508081403L;
	
	@EJB
	private CitaEjb query;
	
	private Cita cita;
	
	public Cita getCita() {
		return cita;
	}
	
	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	@Override
	protected void init() throws BaseException {
		cita = new Cita();
		cita.setDate(new Date());
	}

	@Override
	protected List<Cita> getQueryList() {
		return query.getCitasByDateAndStatus(cita);
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

}
