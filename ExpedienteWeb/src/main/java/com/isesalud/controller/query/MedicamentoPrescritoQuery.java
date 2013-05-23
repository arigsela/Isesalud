/**
 * 
 */
package com.isesalud.controller.query;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.isesalud.ejb.query.MedicamentoprescritoEjb;
import com.isesalud.model.MedicamentoPrescrito;
import com.isesalud.support.components.BaseQueryController;

/**
 * @author ari
 *
 */
@Named
@RequestScoped
public class MedicamentoPrescritoQuery extends BaseQueryController<MedicamentoPrescrito>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6558093489695494143L;
	@EJB
	private MedicamentoprescritoEjb ejb;
	
	@PostConstruct
	public void loadData(){
		setQueryListDM(getQueryList());
	}

	@Override
	protected List<MedicamentoPrescrito> getQueryList() {
		return ejb.getAllMedicamentosPrescritos();
	}

	@Override
	protected int getQueryRowCount() {
		return 0;
	}
}
