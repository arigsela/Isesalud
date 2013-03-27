/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.isesalud.model.Cita;
import com.isesalud.service.dispatchers.SMSRequest;
import com.isesalud.service.support.SMSParams;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean
public class CitaPersistenceEjb extends BasePersistenceManagerEJB<Cita> {

	@Inject
	private SMSRequest request;
	
	@Override
	public Class<Cita> getModelClass() {
		return Cita.class;
	}
	
	public void onUpdateStatus(@Observes Cita c){
		save(c);
	}
	
	@Override
	protected void doAfterAdd(Cita model) throws EJBException {
		SMSParams params = new SMSParams();
		params.setCita(model);
		request.sendMessage(params);
		super.doAfterAdd(model);
	}
	
}
