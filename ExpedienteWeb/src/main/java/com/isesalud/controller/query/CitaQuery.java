/**
 * 
 */
package com.isesalud.controller.query;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.joda.time.DateTime;
import org.primefaces.context.RequestContext;
import org.primefaces.event.ScheduleEntryMoveEvent;
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
 * @author Ing. Ari G. Sela M., Jesus Espinoza Hernandez
 * 
 */
@Named
@ViewScoped
public class CitaQuery extends BaseQueryController<Cita> {

	/**
	 * 
	 */

	private static final long serialVersionUID = 2720894923611511176L;
	
	private final static String VALID_DATE = "Desea crear una cita para esta fecha?";
	private final static String INVALID_DATE = "No se puede agendar una cita en el pasado!";

	private Cita searchParams;

	private Cita selectedCita;

	private ScheduleModel model;

	private ScheduleEvent event = new DefaultScheduleEvent();

	private Date initialDate;

	private Date newCitaDate;
	
	private boolean validDate;
	
	private String message;

	@EJB
	private CitaEjb citaEjb;

	@Inject
	@Any
	private Event<Cita> citaChangedEvent;

	@Override
	protected void init() throws BaseException {
		searchParams = new Cita();
		initialDate = new Date();
	}

	public void showCitaDetails(ActionEvent e) {
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

	public Date getNewCitaDate() {
		return newCitaDate;
	}

	public void setNewCitaDate(Date newCitaDate) {
		this.newCitaDate = newCitaDate;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}
	
	public Cita getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(Cita searchParams) {
		this.searchParams = searchParams;
	}
	
	public boolean isValidDate() {
		return validDate;
	}
	
	public void setValidDate(boolean validDate) {
		this.validDate = validDate;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@PostConstruct
	public void loadData() {
		model = new LazyScheduleModel() {

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

				datasource = getQueryList();

				if (datasource.size() > 0) {
					for (Cita c : datasource) {
						String title = c.getPaciente().getName() + " "
								+ c.getPaciente().getLastName() + " - Edad: "
								+ c.getPaciente().getAge()
								+ " - Tipo de estudio: "
								+ c.getStudy().getName();

						Date date = c.getDate();
						Date time = c.getTime();

						Date result = DateUtil.combineDateTime(date, time);
						Date result2 = DateUtil.addMinutes(result, 10);

						event = new DefaultScheduleEvent(title,
								result, result2);

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

	public void onDateSelected(SelectEvent e) {
		final Date date = (Date) e.getObject();
		DateTime offset = new DateTime(date).minusHours(1); //WARNING WARNING: Temporal bug fix for primefaces schedule.
		if(DateUtil.isDateInThePast(offset)){
			setValidDate(false);
			setMessage(INVALID_DATE);
		} else {
			setValidDate(true);
			setMessage(VALID_DATE);
			setNewCitaDate(offset.toDate());
		}
	}

	public void onEventSelect(SelectEvent e) {
		event = (ScheduleEvent) e.getObject();
		selectedCita = (Cita) event.getData();
		final Date date = DateUtil.combineDateTime(selectedCita.getDate(), selectedCita.getTime());
		setInitialDate(date);
	}

	public void onEventMove(ScheduleEntryMoveEvent e) {
		Cita cita = (Cita) e.getScheduleEvent().getData();
		Date newDay = DateUtil.addDays(cita.getDate(), e.getDayDelta());
		Date newTime = DateUtil.addMinutes(cita.getTime(), e.getMinuteDelta());
		final RequestContext ctx = RequestContext.getCurrentInstance();
		if (DateUtil.isDateInThePast(new DateTime(DateUtil.combineDateTime(
				newDay, newTime)))) {
			ctx.addCallbackParam("isValid", false);
			return;
		} else {
			ctx.addCallbackParam("isValid", true);
		}
		cita.setDate(newDay);
		cita.setTime(newTime);
		citaChangedEvent.fire(cita);
	}
	
	private void processCitaChanged(){
		selectedCita.setDate(initialDate);
		selectedCita.setTime(initialDate);
		citaChangedEvent.fire(selectedCita);
	}

	public void onCitaChanged(ActionEvent e) {
		processCitaChanged();
	}
	
	public void onCitaChangedAndAddResults(ActionEvent e){
		processCitaChanged();
		
	}

	public void clearSelected() {
		selectedCita = null;
	}
	
	@Override
	public String navigate() {
		processCitaChanged();
		setOutcome("/radiologia/EstudioEntrada?faces-redirect=true");
		return super.navigate();
	}
	
	@Override
	protected List<Cita> getQueryList() {
		return citaEjb.getCitasByDateRange(searchParams);
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
	
	public static void main(String[] args){
		String[] ids = TimeZone.getAvailableIDs();
		for (String id : ids){
			System.out.println(id);
		}
	}
}
