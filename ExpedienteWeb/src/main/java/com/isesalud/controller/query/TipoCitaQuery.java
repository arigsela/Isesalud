/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.TipocitaEjb;
import com.isesalud.model.Tipocita;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author Ari G. Sela M.
 *
 */

@Named
@ViewScoped

public class TipoCitaQuery extends BaseQueryController<Tipocita>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -898892696853006426L;
	
	@EJB
	private TipocitaEjb ejb;

	@PostConstruct
	public void init(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<Tipocita> getQueryList() {
		return ejb.getAllTipoCita();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
