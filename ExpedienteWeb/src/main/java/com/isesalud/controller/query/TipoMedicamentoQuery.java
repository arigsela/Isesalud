/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.TipoMedicamentoEjb;
import com.isesalud.model.TipoMedicamento;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class TipoMedicamentoQuery extends BaseQueryController<TipoMedicamento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6141142656497990379L;
	@EJB
	private TipoMedicamentoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<TipoMedicamento> getQueryList() {
		return ejb.getAllTiposMedicamento();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
