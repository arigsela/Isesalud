package com.isesalud.service;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.jboss.solder.logging.Logger;

import com.isesalud.ejb.query.PacienteEjb;
import com.isesalud.service.support.SMSParams;
import com.isesalud.support.CompareUtil;
import com.isesalud.support.DateUtil;
import com.nexmo.messaging.sdk.NexmoSmsClient;
import com.nexmo.messaging.sdk.SmsSubmissionResult;
import com.nexmo.messaging.sdk.messages.TextMessage;

/**
 * Message-Driven Bean implementation class for: SMSService
 */
@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
				@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/sms"),
				@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
				}
		)
public class SMSService implements MessageListener {
	
	private Logger log = Logger.getLogger(getClass());
	
	public static final String API_KEY = "07284def";
	public static final String API_SECRET = "655bb477";
	public static final String SMS_FROM = "526642865641";
	public static final String SMS_TO = "526643755483";
	public static final String SMS_TEXT = "LA SECRETARIA DE SALUD DEL GOBIERNO DEL ESTADO DE BAJA CALIFORNIA SE PREOCUPAN POR TI. RECUERDA QUE MAÑANA ES TU CITA PARA LA MASTOGRAFIA";
	
	private NexmoSmsClient client;
	
	@EJB
	private PacienteEjb pacienteEjb;

    /**
     * Default constructor. 
     */
    public SMSService() {
       
    }
    
    @PostConstruct
    public void initialize(){
    	try {
			client = new NexmoSmsClient(API_KEY, API_SECRET);
			log.info("Initialized SMS service");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	ObjectMessage msg = null;
    	SMSParams params = null;
    	
    	if(message instanceof ObjectMessage){
    		msg = (ObjectMessage) message;
    		
			try {
				if(msg.getObject() instanceof SMSParams){
					params = (SMSParams) msg.getObject();
					constructMessage(params);
					sendSMS(params);
				}
			} catch (JMSException e) {
				log.error(e.getMessage());
			}
    	}
    }
    
    private void constructMessage(SMSParams params){
    	DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
    	
    	Date date = params.getCita().getDate();
    	Date time = params.getCita().getTime();
    	
    	Date result = DateUtil.combineDateTime(date, time);
    	
    	String msg = "Su cita a sido programada para el " +
    				df.format(result);
    	params.setMsg(msg);
    }
    
    private void sendSMS(SMSParams params){
    	try{
    		SmsSubmissionResult[] results = null;
        	if(!CompareUtil.isEmpty(params.getMsg()) && !CompareUtil.isEmpty(params.getCita().getPaciente().getPhoneNumberMovil())){
        		String to = "52" + params.getCita().getPaciente().getPhoneNumberMovil();
        		TextMessage message = new TextMessage(SMS_FROM, to, params.getMsg());
        		results = client.submitMessage(message);
        		printSMSResults(results);
        	}
    	}catch(Exception e){
    		e.printStackTrace();
    		log.error("Failed to communicate with the Nexmo Client");
    	}
    }
    
    private void printSMSResults(SmsSubmissionResult[] results){
    	log.infov("... Message submitted in [ {0} ] parts", results.length);
        for (int i=0;i<results.length;i++) {
            log.infov("-------- part [ {0} ] ---------", (i+1));
            log.infov("Status [ {0} ] ...", results[i].getStatus());
            if (results[i].getStatus() == SmsSubmissionResult.STATUS_OK)
            	log.info("SUCCESS");
            else if (results[i].getTemporaryError())
            	log.info("TEMPORARY FAILURE - PLEASE RETRY");
            else
            	log.info("SUBMISSION FAILED!");
            log.infov("Message-Id [ {0} ] ...", results[i].getMessageId());
            log.infov("Error-Text [ {0} ] ...", results[i].getErrorText());

            if (results[i].getMessagePrice() != null)
                System.out.println("Message-Price [ " + results[i].getMessagePrice() + " ] ...");
            	log.infov("Message-Price [ {0} ] ...", results[i].getMessagePrice());
            if (results[i].getRemainingBalance() != null)
            	log.infov("Remaining-Balance [ {0} ] ...", results[i].getRemainingBalance());
        }
    }
    
    public void checkUpcomingCita(){
    	
    }

}
