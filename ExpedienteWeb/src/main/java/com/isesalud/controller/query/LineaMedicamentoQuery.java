/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.LineaMedicamentoEjb;
import com.isesalud.model.LineaMedicamento;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class LineaMedicamentoQuery extends BaseQueryController<LineaMedicamento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7349622399383516733L;
	@EJB
	private LineaMedicamentoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<LineaMedicamento> getQueryList() {
		return ejb.getAllLineasMedicamentos();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
