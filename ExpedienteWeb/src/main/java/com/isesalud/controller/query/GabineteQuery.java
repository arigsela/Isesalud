
/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.GabineteEjb;
import com.isesalud.model.Gabinete;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@ViewScoped
public class GabineteQuery extends BaseQueryController<Gabinete>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8922240740274961299L;
	@EJB
	private GabineteEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<Gabinete> getQueryList() {
		return ejb.getAllGabinetes();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

}
