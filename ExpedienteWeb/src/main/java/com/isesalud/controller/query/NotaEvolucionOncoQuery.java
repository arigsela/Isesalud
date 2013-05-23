/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.NotaEvolucionOncoEjb;
import com.isesalud.model.NotaEvolucionOnco;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class NotaEvolucionOncoQuery extends BaseQueryController<NotaEvolucionOnco>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6548809137658674498L;
	@EJB
	private NotaEvolucionOncoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<NotaEvolucionOnco> getQueryList() {
		return ejb.getAllNotasEvolucionOnco();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
