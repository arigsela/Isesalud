/**
 * 
 */
package com.isesalud.controller.query;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.isesalud.ejb.query.CitaEjb;
import com.isesalud.model.Cita;
import com.isesalud.support.DateUtil;
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
	
	private ScheduleModel model;
	
	private ScheduleEvent event = new DefaultScheduleEvent();
	
	private Date initialDate;
	
	@EJB
	private CitaEjb citaEjb;
	
	@Inject @Any
	private Event<Cita> statusChangedEvent;
	
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
	
	public void setSelectedCita(Cita selectedCita) {
		this.selectedCita = selectedCita;
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
	
	public ScheduleEvent getEvent() {
		return event;
	}
	
	public void setEvent(ScheduleEvent event) {
		this.event = event;
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
								c.getPaciente().getLastName() + " - Edad: " +
								c.getPaciente().getAge() + " - Tipo de estudio: " +
								c.getTipoestudiocita().getName();
								
						Date date = c.getDate();
						Date time = c.getTime();

						Date result = DateUtil.combineDateTime(date, time);
						Date result2 = DateUtil.addMinutes(result, 10);
						
						event = new DefaultScheduleEvent(title, 
								dstDate(result), dstDate(result2));
						
						event.setData(c);
						
						event.setStyleClass(c.getStatuscita().getDescription());
						
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
	
	public void onEventSelect(SelectEvent e){
		event = (ScheduleEvent) e.getObject();
		selectedCita = (Cita) event.getData();
	}
	
	public void onStatusChanged(ActionEvent e){
		statusChangedEvent.fire(selectedCita);
	}
	
	public void clearSelected(){
		selectedCita = null;
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
}
