/**
 * 
 */
package com.isesalud.controller.query;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.isesalud.ejb.query.CitaEjb;
import com.isesalud.model.Cita;
import com.isesalud.support.components.BaseQueryController;

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
	
	private Date day;
	
	public Date getDay() {
		return day;
	}
	
	public void setDay(Date day) {
		this.day = day;
	}

	@Override
	protected List<Cita> getQueryList() {
		Cita params = new Cita();
		params.setDate(day);
		return query.getCitasByDate(params);
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

}
