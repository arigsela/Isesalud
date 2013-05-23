/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.TNMOncoEjb;
import com.isesalud.model.TNMOnco;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class TNMOncoQuery extends BaseQueryController<TNMOnco>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6228414820230261537L;
	@EJB
	private TNMOncoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<TNMOnco> getQueryList() {
		return ejb.getAllTNMOnco();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}

}
