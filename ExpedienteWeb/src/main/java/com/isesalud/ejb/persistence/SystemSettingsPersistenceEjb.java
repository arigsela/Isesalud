/**
 * 
 */
package com.isesalud.ejb.persistence;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import com.isesalud.model.SystemSettings;
import com.isesalud.support.components.BasePersistenceManagerEJB;

/**
 * @author ari
 *
 */
@Stateless
@LocalBean
public class SystemSettingsPersistenceEjb extends BasePersistenceManagerEJB<SystemSettings>{
	
	@Override
	public Class<SystemSettings> getModelClass() {
		return SystemSettings.class;
	}
}
