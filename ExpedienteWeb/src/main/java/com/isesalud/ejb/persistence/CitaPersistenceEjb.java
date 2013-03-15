/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import com.isesalud.model.Cita;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */

@Stateless
@LocalBean
public class CitaPersistenceEjb extends BasePersistenceManagerEJB<Cita> {

	
	
	@Override
	public Class<Cita> getModelClass() {
		return Cita.class;
	}
	
	public void onUpdateStatus(@Observes Cita c){
		save(c);
	}
	
}
