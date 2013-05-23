/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.TipoLineaMedicamentoEjb;
import com.isesalud.model.TipoLineaMedicamento;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class TipoLineaMedicametoQuery extends BaseQueryController<TipoLineaMedicamento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5131826950253178947L;
	@EJB
	private TipoLineaMedicamentoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<TipoLineaMedicamento> getQueryList() {
		return ejb.getAllTiposLIneaMedicamento();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
