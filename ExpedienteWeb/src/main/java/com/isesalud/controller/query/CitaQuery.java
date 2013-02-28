/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.isesalud.ejb.query.CitaEjb;
import com.isesalud.model.Cita;
import com.isesalud.support.components.BaseQueryController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author Ing. Ari G. Sela M.
 *
 */

@Named
@ViewScoped
public class CitaQuery extends  BaseQueryController<Cita>{

	/**
	 * 
	 */

	private static final long serialVersionUID = 2720894923611511176L;

	private Cita searchParams;
	
	private Cita selectedCita;
	
	@EJB
	private CitaEjb citaEjb;
	
	@Override
	protected void init() throws BaseException {
		searchParams = new Cita();
	}
	
	public void showCitaDetails(ActionEvent e){
		Cita p = (Cita) e.getComponent().getAttributes().get("detail");
		Cita full = citaEjb.getFULL(p.getId());
		setSelectedCita(full);
	}
	
	public Cita getSelectedCita() {
		return selectedCita;
	}
		
	@Override
	public void query(ActionEvent e) {
		
		if(getSearchParams() != null){
			clearSelected();
			super.query(e);
			
		} else{
			try {
				init();
			} catch (BaseException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void clearSelected(){
		selectedCita = null;
	}
	
	public void setSelectedCita(Cita selectedCita) {
		this.selectedCita = selectedCita;
	}
	
	public Cita getSearchParams() {
		return searchParams;
	}
	
	public void setSearchParams(Cita searchParams) {
		this.searchParams = searchParams;
	}
			
	@Override
	protected List<Cita> getQueryList() {
		return citaEjb.getAllCita();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
