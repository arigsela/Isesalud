/**
 * 
 */
package com.isesalud.converters;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import com.isesalud.ejb.query.SystemSettingsEjb;
import com.isesalud.model.SystemSettings;

/**
 * @author ari
 *
 */
@Named
@FacesConverter("SystemSettingsConverter")
@RequestScoped

public class SystemSettingsConverter extends AbstractConverter<SystemSettings, SystemSettingsEjb> {

	@EJB
	private SystemSettingsEjb manager;
	
	@Override
	protected SystemSettingsEjb getCManager() {
		return this.manager;
	}
	
}
