/**
 * 
 */
package com.isesalud.service.dispatchers;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import com.isesalud.service.support.SMSParams;
import com.isesalud.support.components.BaseComponent;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Named
@SessionScoped
public class SMSRequest extends BaseComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1070254766596082668L;
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(mappedName="java:/queue/sms")
	private Queue queueSMS;

	/**
	 * 
	 */
	public SMSRequest() {
		
	}
	
	public void sendMessage(SMSParams params){
		Connection connection = null;
		
		try{
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			ObjectMessage msg = session.createObjectMessage();
			if(params != null){
				msg.setObject(params);
				
				MessageProducer producer = session.createProducer(queueSMS);
				
				connection.start();
				
				producer.send(msg);
				
			} else {
				throw new IllegalArgumentException("SMS params cannot be null");
			}
		}catch(JMSException e){
			
		} finally{
			if(connection != null){
				try {
					connection.close();
				} catch (JMSException e) {
					log.fatal(e.getMessage());
				}
			}
		}
	}

}
