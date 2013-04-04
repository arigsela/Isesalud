/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.SystemSettingsEjb;
import com.isesalud.model.SystemSettings;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@ViewScoped
public class SystemSettingsQuery extends BaseQueryController<SystemSettings>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2379109202088909245L;
	@EJB
	private SystemSettingsEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}
	
	@Override
	protected List<SystemSettings> getQueryList() {
		return ejb.getAllSystemSettings();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
	
}
