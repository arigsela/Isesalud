/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.MotivoInadecuadaEjb;
import com.isesalud.model.MotivoInadecuada;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@ViewScoped
public class MotivoInadecuadaQuery extends BaseQueryController<MotivoInadecuada>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 391073010365151689L;
	@EJB
	private MotivoInadecuadaEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<MotivoInadecuada> getQueryList() {
		return ejb.getAllMotivos();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
