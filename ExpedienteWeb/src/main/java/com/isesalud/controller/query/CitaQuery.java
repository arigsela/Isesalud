/**
 * 
 */
package com.isesalud.controller.query;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.jboss.seam.faces.context.RenderScoped;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;

import com.isesalud.ejb.query.CitaEjb;
import com.isesalud.model.Cita;
import com.isesalud.support.components.BaseQueryController;
import com.isesalud.support.exceptions.BaseException;

/**
 * @author Ing. Ari G. Sela M.
 *
 */

@Named
@RenderScoped
public class CitaQuery extends  BaseQueryController<Cita>{

	/**
	 * 
	 */

	private static final long serialVersionUID = 2720894923611511176L;

	private Cita searchParams;
	
	private Cita selectedCita;
	
	private ScheduleModel model;
	
	private Date initialDate;
	
	@EJB
	private CitaEjb citaEjb;
	
	@Override
	protected void init() throws BaseException {
		searchParams = new Cita();
		initialDate = new Date();
	}
	
	public void showCitaDetails(ActionEvent e){
		Cita p = (Cita) e.getComponent().getAttributes().get("detail");
		Cita full = citaEjb.getFULL(p.getId());
		setSelectedCita(full);
	}
	
	public Cita getSelectedCita() {
		return selectedCita;
	}
	
	public ScheduleModel getModel() {
		return model;
	}
	
	public void setModel(ScheduleModel model) {
		this.model = model;
	}
	
	public Date getInitialDate() {
		return initialDate;
	}
	
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	
	private Date dstDate(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int offset = c.get(Calendar.DST_OFFSET);
		if(offset != 0){
			c.add(Calendar.HOUR_OF_DAY, 1);
		}
		
		return c.getTime();
	}
	
	@PostConstruct
	public void loadData(){
		model = new LazyScheduleModel(){
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void loadEvents(Date start, Date end) {
				List<Cita> datasource = null;
				DefaultScheduleEvent event = null;
				
				clear();
				
				searchParams.setStartDate(start);
				searchParams.setEndDate(end);
				
				datasource = citaEjb.getCitasByDateRange(searchParams);
				
				if(datasource.size() > 0){
					for(Cita c : datasource){
						String title = c.getPaciente().getName() + " " +
								c.getPaciente().getLastName() + " - " +
								c.getTipoestudiocita().getName();
						
						Date date = c.getDate();
						Date time = c.getTime();
						
						Calendar calDT = Calendar.getInstance();
						calDT.setTime(date);
						
						Calendar calT = Calendar.getInstance();
						calT.setTime(time);
						
						calDT.set(Calendar.HOUR_OF_DAY, calT.get(Calendar.HOUR_OF_DAY));
						calDT.set(Calendar.MINUTE, calT.get(Calendar.MINUTE));
						calDT.set(Calendar.SECOND, calT.get(Calendar.SECOND));
						calDT.set(Calendar.MILLISECOND, calT.get(Calendar.MILLISECOND));
						
						Date result = calDT.getTime();
						calDT.add(Calendar.MINUTE, 10);
						Date result2 = calDT.getTime();
						
						event = new DefaultScheduleEvent(title, 
								dstDate(result), dstDate(result2));
						
						event.setData(c);
						
						addEvent(event);
						
					}
				}
			};
		};
	}
		
	@Override
	public void query(ActionEvent e) {
		loadData();
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
		return null;
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
	
	public static void main(String[] args){
		CitaQuery query = new CitaQuery();
		Date test = query.dstDate(new Date());
		System.out.println(test.toString());
	}
}
