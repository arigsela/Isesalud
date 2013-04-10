package com.isesalud.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.inject.Inject;

import org.jboss.solder.logging.Logger;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Days;

import com.isesalud.controller.application.ApplicationSettings;
import com.isesalud.ejb.persistence.CitaPersistenceEjb;
import com.isesalud.ejb.query.CitaEjb;
import com.isesalud.model.Cita;
import com.isesalud.service.dispatchers.SMSRequest;
import com.isesalud.service.support.SMSParams;

@Singleton
@Startup
@LocalBean
public class SMSReminderService {

	/**
	 * Setup our logger
	 */
	private Logger log = Logger.getLogger(getClass());
	
	@Inject
	private SMSRequest smsRequest;
	
	@Inject
	private ApplicationSettings settings;
	
	/**
	 * Get the citas ejb so we can query them.
	 */
	@EJB
	private CitaEjb citaEjb;
	
	@EJB
	private CitaPersistenceEjb citaPersistenceEjb;
	
    /**
     * Default constructor. 
     */
    public SMSReminderService() {
    	
    }
	
    /**
     * Timeout method. Declares an automatic ejb timer scheduled to fire 
     * for the rest of eternity between 8am and 3pm.
     * @param t
     * Timer object passed to the method by the ejb timer service.
     */
	@Schedule(hour="8-15", month="*")
    private void scheduledTimeout(final Timer t) {
        log.info("Scanning scheduled citas for sending sms.");
        
        processReminders();
    }
	
	/**
	 * Business method.
	 */
	private void processReminders(){
		List<Cita> citas = citaEjb.getFutureCitasForSms();
		
		if(citas.size() > 0){
			log.infov("Sending {0} messages to patients", citas.size());
			
			for(Cita c : citas){
				DateTime day = new DateTime(c.getDate());
				if(isCitaNextDay(day) && 
						c.getPaciente().getAceptarmensajes() &&
						settings.getModel().getMessagesenabled() &&
						!c.getEnviadosms()){
					
					SMSParams params = new SMSParams();
					params.setCita(c);
					params.setNextDayMsg(true);
					smsRequest.sendMessage(params);
				}
			}
		}
		
	}
	
	private boolean isCitaNextDay(final DateTime date){
		DateTime now = new DateTime();
		return (Days.daysBetween(new DateMidnight(now), new DateMidnight(date)).getDays() == 1) ? true : false;
	}
}