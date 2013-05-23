/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.isesalud.ejb.query.TipoEstadoActualPacienteoncoEjb;
import com.isesalud.model.TipoEstadoActualPacienteOnco;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class TipoEstadoActualPacienteOncoQuery extends BaseQueryController<TipoEstadoActualPacienteOnco>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -849505115281646334L;
	@EJB
	private TipoEstadoActualPacienteoncoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<TipoEstadoActualPacienteOnco> getQueryList() {
		return ejb.getAllTiposEstadoActualPacienteOnco();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
