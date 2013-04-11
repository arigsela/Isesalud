/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.jboss.security.auth.spi.Util;
import org.jboss.solder.logging.Logger;

import com.isesalud.model.User;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
@Stateless
@LocalBean
public class UserPersistenceEjb extends BasePersistenceManagerEJB<User> {

	private Logger log = Logger.getLogger(getClass());
	
	@Override
	public Class<User> getModelClass() {
		return User.class;
	}
	
	private void HashUserPassword(User model){
		log.info("Applying hash alorithm to password");
		String hash = Util.createPasswordHash("SHA-256", Util.BASE64_ENCODING, null, null, model.getPassword());
		model.setPassword(hash);
	}
	
	@Override
	protected void doBeforeAdd(User model) throws EJBException {
		HashUserPassword(model);
		super.doBeforeAdd(model);
	}
	
	@Override
	protected void doBeforeUpdate(User model) throws EJBException {
		if(model.isHashPassword())
			HashUserPassword(model);
		
		super.doBeforeUpdate(model);
	}

}
